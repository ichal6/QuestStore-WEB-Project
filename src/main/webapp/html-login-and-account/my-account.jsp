<%@ page import="Session.SessionManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My account</title>
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/my-account.css">
</head>

<body onload="checkName();checkEmail();checkPasswordForRegEx();checkIfPasswordsAreEquals();">
    <jsp:include page="../html-common/cms-header.jsp" />
    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div id="content">
            <h1 id="label">My Account</h1>
            <div id="information"> 
                <h2 id="label-profil">Profile Information</h2>
                <form action="/cms-user/my-account" method="post">
                    <label>Name*:</label><br>
                    <input type="text" id="name-and-surname" class="name-surname" value="${SessionManager.getActualUser().getName()}"><br>
                    <div class="warning hidden">
                        <p>Your name is invalid</p>
                    </div>
                    <label>Email*:</label><br>
                    <input type="text" id="e-mail" class="email-input" value="${SessionManager.getActualUser().getEmail()}" ><br>
                    <div class="warning-email hidden">
                        <p>Your mail is invalid</p>
                    </div>

                <div id="information-bottom">
                    <div id="picture">
                        <p>Picture:</p>
                        <img src="${SessionManager.getActualUser().getPictureURL()}" alt="profile photo"><br>
                    </div>
                    <a href="#"> <img src="../assets/icons/change_picture.svg" alt="change photo">Change picture</a>
                    <p id="role-content">Role: ${SessionManager.getActualUser().getRole()}</p>
                    <button type="submit" id="update" disabled>Update</button>
                </div>
                </form>
            </div>

            <div id="change-password">
                <h2 id="label-password">Change Password</h2>
                <form>
                    <label>Old password*:</label><br>
                    <input type="password" id="old-password"><br>
                    <label>New password*:</label><br>
                    <input type="password" id="new-password" class="passw-input"><br>
                    <div class="warning-password hidden">
                        <p>Your password is invalid</p>
                    </div>
                    <label>Repeat new password*:</label><br>
                    <input type="password" id="repeat-new-password" class="sec-passw"><br>
                    <div class="warning-equals hidden">
                        <p>Your passwords are not equals.</p>
                    </div>
                </form>
                <div id="change-password-button" class="button">
                    <button >Change password</button>
                </div>
                
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
    <script src="../js/input-validator.js"></script>
</body>

</html>