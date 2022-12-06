<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import ="java.io.File, com.example.*"%>
<%@ page import ="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>FILE</title>
</head>
<body>
<%
  String filename="";
  int sizeLimit = 15 * 1024 * 1024;

  String realPath = request.getServletContext().getRealPath("upload");
  File dir = new File(realPath);
  if(!dir.exists()) dir.mkdirs();

  MultipartRequest multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

  filename = multipartRequest.getFilesystemName("image");

  request.setAttribute("filename", filename);
%>
</body>
</html>