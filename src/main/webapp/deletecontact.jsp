<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.dao.ContactDAO, com.example.bean.ContactVO"%>
<%@ page import="com.example.FileUpload" %>
<%
    String contactID = request.getParameter("id");
    System.out.println("id = " + contactID);
    if(contactID != ""){
        int id = Integer.parseInt(contactID);
        ContactDAO contactDAO = new ContactDAO();
        String filename = contactDAO.getImageFilename(id);
        if(filename != null)
            FileUpload.deleteFile(request, filename);
        contactDAO.deleteContact(id);
    }

    response.sendRedirect("contacts.jsp");
%>