<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/person_add_update.css">
    <title>Update level details</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Level's details</h1>
            <a href="levels_list.jsp">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details:</h2>
                <label for="level-name">Name*:</label>
                <input type="text" id="level-name" value="Level I with super name">
                <label for="level-description">Description*:</label>
                <textarea id="level-description" >A few words about my super level, how cool I am to get it.</textarea>
                <div class="img-coins">
                    <div>
                        <p>Picture*:</p>
                        <img src="../assets/img/user-photo.svg" alt="Here should be uploaded image" class="thumbail-img">
                        <a href=""><img src="../assets/img/change-img.svg" alt="Change image icon" class="change-img-icon">Change picture:</a>
                    </div>
                    <div class="level-coins">
                        <label for="level-coins">Cost (number of coins to get)*:</label>
                        <input type="number" id="level-coins" value="200">
                    </div>
                </div>
                <div class="lower-section">
                    <p>*- Fields marked like the need to be filled to add new entry</p>
                    <button class="btn" id="update-level">Update level</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
    <script>
        document.getElementsByClassName('levels-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>

</html>