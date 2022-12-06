<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ADD</title>
    <link rel="stylesheet" href="./css/my.css">
    <script>
        function name_check(){
            var name = document.add_form.contactName;
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
                <h1>Add Contact</h1>
                <p>To add the contact, fill in the blanks below.</p>
            </div>

            <div class="form_container">
                <form name="add_form" action="addcontact.jsp" method="post" class="new_contact" enctype="multipart/form-data" onsubmit="return name_check()">
                    <label>Name</label><br>
                    <input type="text" name="contactName">
                    <br><br>
                    <label>Phone Number</label><br>
                    <input type="tel" name="contactPhone" placeholder="010-1234-5678"
                           pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13">
                    <br><br>
                    <label>Email</label><br>
                    <input type="text" name="contactEmail" placeholder="example@email.com">
                    <br><br>
                    <label>Birthday</label><br>
                    <input type="date" name="contactBirthday" min="1900-01-01" max="2022-12-31">
                    <br><br>
                    <label>Image</label><br>
                    <input type="file" name="image">
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
