<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.dao.ContactDAO, com.example.FileUpload"%>
<%@ page import="com.example.bean.ContactVO" %>

<%
    request.setCharacterEncoding("utf-8");
    ContactDAO contactDAO = new ContactDAO();
    FileUpload upload = new FileUpload();
    ContactVO u = upload.uploadImage(request);

    int i = contactDAO.updateContact(u);
    String msg = "데이터 수정 성공!";
    if(i==0) msg = "[에러] 데이터 수정 실패!";
%>

<script>
    alert('<%=msg%>');
    location.href='contacts.jsp';
</script>