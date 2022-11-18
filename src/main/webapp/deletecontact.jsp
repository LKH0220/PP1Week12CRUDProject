<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<%
    String sid = request.getParameter("id");
    System.out.println("id = " + sid);
    if (sid != ""){
        int id = Integer.parseInt(sid);
        BoardVO u = new BoardVO();
        u.setContactID(id);
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(u);
    }
    response.sendRedirect("posts.jsp");
%>