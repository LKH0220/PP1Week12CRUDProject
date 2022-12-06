<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.dao.ContactDAO, com.example.bean.ContactVO"%>
<%
    ContactDAO contactDAO = new ContactDAO();
    String id = request.getParameter("id");
    ContactVO u=contactDAO.getContact(Integer.parseInt(id));
    request.setAttribute("vo", u);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EDIT</title>
    <link rel="stylesheet" href="./css/my.css">
    <script>
        function name_check(){
            var name = document.edit_form.contactName;
            if(name.value == ""){
                alert("Please enter contact's name");
                name.focus();
                return false;
            }
        }
    </script>

</head>

<body>
<div class="container">
    <header>
        <div class="nav_bar">
            <div class="logo"><a href="contacts.jsp">LOGO</a></div>
            <nav class="menu">
                <a href="contacts.jsp">CONTACTS</a>
                <a href="#">NOTICE</a>
                <a href="#">LOREM</a>
                <a href="#">IPSUM</a>
            </nav>
        </div>
    </header>

    <main>
        <div class="contents">
            <div class="Title">
                <h1>Edit Contact</h1>
                <p>To edit the contact, revise the contents below.</p>
            </div>

            <div class="form_container">
                <form name="edit_form" action="editcontact.jsp" method="post" enctype="multipart/form-data" class="new_contact" onsubmit="return name_check()">
                    <input type="hidden" name="contactID" value="<%=u.getContactID() %>"/>
                    <label>Name</label><br>
                    <input type="text" name="contactName" value="<%=u.getContactName()%>">
                    <br><br>
                    <label>Phone Number</label><br>
                    <input type="tel" name="contactPhone" placeholder="010-1234-5678"
                           pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13" value="<%=u.getContactPhone()%>">
                    <br><br>
                    <label>Email</label><br>
                    <input type="text" name="contactEmail" placeholder="example@email.com" value="<%=u.getContactEmail()%>">
                    <br><br>
                    <label>Birthday</label><br>
                    <input type="date" name="contactBirthday" min="1900-01-01" max="2022-12-31" value="<%=u.getContactBirthday()%>">
                    <br><br>
                    <label>Image</label><br>
                    <input type="file" name="image" value="<%=u.getImage()%>">
                    <br><br>
                    <input type="reset" value="Reset">
                    <input type="submit" value="Submit">
                </form>
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
