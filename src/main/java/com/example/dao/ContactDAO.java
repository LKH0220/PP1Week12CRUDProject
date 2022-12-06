package com.example.dao;

import com.example.bean.ContactVO;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ContactDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String CONTACT_INSERT = "insert into Contacts (Image, ContactName, ContactPhone, ContactEmail, ContactBirthday) values (?,?,?,?,?)";
    private final String CONTACT_UPDATE = "update Contacts set Image=?, ContactName=?, ContactPhone=?, ContactEmail=?, ContactBirthday=? where ContactID=?";
    private final String CONTACT_DELETE = "delete from Contacts where ContactID=?";
    private final String CONTACT_GET = "select * from Contacts where ContactID=?";
    private final String CONTACT_LIST = "select * from Contacts order by ContactID desc";

    public int insertContact(ContactVO vo) {
        System.out.println("===> JDBC로 insertContact() 기능 처리");
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

    public void deleteContact(int id) {
        System.out.println("===> JDBC로 deleteContact() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateContact(ContactVO vo) {
        System.out.println("===> JDBC로 updateContact() 기능 처리");
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

    public ContactVO getContact(int contactID) {
        ContactVO one = new ContactVO();
        System.out.println("===> JDBC로 getContact() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_GET);
            stmt.setInt(1, contactID);
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

    public List<ContactVO> getContactList() {
        List<ContactVO> list = new ArrayList<ContactVO>();
        System.out.println("===> JDBC로 getContactList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ContactVO one = new ContactVO();
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

    public String getImageFilename(int contactID) {
        String filename = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CONTACT_GET);
            stmt.setInt(1, contactID);
            rs = stmt.executeQuery();
            if(rs.next()) {
                filename = rs.getString("Image");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}
