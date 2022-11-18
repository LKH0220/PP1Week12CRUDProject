<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.example.bean.BoardVO, com.example.dao.BoardDAO, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> list = boardDAO.getBoardList();
        request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>INDEX</title>
    <link rel="stylesheet" href="./css/my.css">
    <script>
        function delete_ok(id){
            var a = confirm("정말로 삭제하겠습니까?");
            if(a) location.href='deletepost.jsp?id=' + id;
        }
    </script>
</head>

<body>
<div class="container">
    <header>
        <div class="nav_bar">
            <div class="logo">LOGO</div>
            <nav class="menu">
                <a href="#">CONTACTS</a>
                <a href="#">NOTICE</a>
                <a href="#">LOREM</a>
                <a href="#">IPSUM</a>
            </nav>
        </div>
    </header>

    <main>
        <div class="contents">
            <div class="upper_contents">
                <h2>Contacts</h2>
                <div class="table_top_menu">
                    <form action="#" method="get">
                        <input type="text" name="search_contact" id="search_contact" placeholder="Search here">
                        <button type="button"><img src="./img/search.png" width="26"></button>
                    </form>
                    <div class="icons">
                        <a href="addform.jsp"><img src="./img/add-user.png" width="26"></a>
                    </div>
                </div>
            </div>

            <div class="table-responsive">
                <hr class="one">
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Birthday</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="u">
                    <tr>
                        <td>${u.getContactID()}</td>
                        <td>${u.getImage()}</td>
                        <td>${u.getContactName()}</td>
                        <td>${u.getContactPhone()}</td>
                        <td>${u.getContactEmail()}</td>
                        <td>${u.getContactBirthday()}</td>
                        <td>
                            <a href="editform.jsp?id=${u.getContactID()}"><img src="./img/edit.png" width="24"></a>
                            <a href="javascript:delete_ok('${u.getContactID()}')"><img src="./img/delete.png" width="24"></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <hr class="one">
            </div>
        </div>
    </main>

    <footer>
        <div class="copyright">
            <p>
                Content from this site may not be reproduced without prior written permission.<br>
                Copyright ⓒ 2022. LeeKanghyun All right reserved.
            </p>
        </div>
    </footer>

</div>
</body>
</html>