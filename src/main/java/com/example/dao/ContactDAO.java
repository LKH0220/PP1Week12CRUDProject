package com.example.dao;

import com.example.bean.BoardVO;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String CONTACT_INSERT = "insert into Contacts (Image, ContactName, ContactPhone, ContactEmail, ContactBirthday) values (?,?,?,?,?)";
    private final String CONTACT_UPDATE = "update Contacts set Image=?, ContactName=?, ContactPhone=?, ContactEmail=?, ContactBirthday=? where ContactID=?";
    private final String CONTACT_DELETE = "delete from Contacts where ContactID=?";
    private final String CONTACT_GET = "select * from Contacts where ContactID=?";
    private final String CONTACT_LIST = "select * from Contacts order by ContactID desc";

    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_INSERT);
            stmt.setString(1, vo.getImage());
            stmt.setString(2, vo.getContactName());
            stmt.setString(3, vo.getContactPhone());
            stmt.setString(4, vo.getContactEmail());
            stmt.setString(5, vo.getContactBirthday());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteBoard(BoardVO vo) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_DELETE);
            stmt.setInt(1, vo.getContactID());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateBoard(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_UPDATE);
            stmt.setString(1, vo.getImage());
            stmt.setString(2, vo.getContactName());
            stmt.setString(3, vo.getContactPhone());
            stmt.setString(4, vo.getContactEmail());
            stmt.setString(5, vo.getContactBirthday());
            stmt.setInt(6, vo.getContactID());

            System.out.println(vo.getImage() + "-" + vo.getContactName() + "-" + vo.getContactPhone() + "-" + vo.getContactEmail() + "-" + vo.getContactBirthday()+ "-" + vo.getContactID());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public BoardVO getBoard(int contactId) {
        BoardVO one = new BoardVO();
        System.out.println("===> JDBC로 getBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_GET);
            stmt.setInt(1, contactId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                one.setContactID(rs.getInt("ContactID"));
                one.setImage(rs.getString("Image"));
                one.setContactName(rs.getString("ContactName"));
                one.setContactPhone(rs.getString("ContactPhone"));
                one.setContactEmail(rs.getString("ContactEmail"));
                one.setContactBirthday(rs.getString("ContactBirthday"));
                one.setRegdate(rs.getDate("Regdate"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<BoardVO> getBoardList() {
        List<BoardVO> list = new ArrayList<BoardVO>();
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BoardVO one = new BoardVO();
                one.setContactID(rs.getInt("ContactID"));
                one.setImage(rs.getString("Image"));
                one.setContactName(rs.getString("ContactName"));
                one.setContactPhone(rs.getString("ContactPhone"));
                one.setContactEmail(rs.getString("ContactEmail"));
                one.setContactBirthday(rs.getString("ContactBirthday"));
                one.setRegdate(rs.getDate("Regdate"));

                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
