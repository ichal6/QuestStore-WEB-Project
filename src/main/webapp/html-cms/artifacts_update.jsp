<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/artifact_update.css">
    <title>Update artifacts</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Artifact’s details</h1>
            <a href="artifacts_list.jsp">&#60;- Back to the list</a>
            <div class="artifacts-details">
                <h2>Basic details</h2>
                <label for="artifacts-name">Name*:</label>
                <input type="text" id="artifacts-name" value="1 hour consultation with mentor">
                <label for="artifacts-descripton">Description*:</label>
                <textarea id="artifacts-descripton">You’ve earned 1 hour consultation with choosen mentor. Contact him/her to settle the details.</textarea> 
                <div class="proporties-section">
                    <div class="picture">
                        <p>Picture: </p>
                        <img id="artifacts-logo" src="../assets/img/artifacts-images/artifacts_7.svg" alt="artifact logo"><br>
                        <a href="#"><img src="../assets/icons/change_picture.svg" alt=" ">Change picture</a> 
                    </div>
                    <div class=proporties>
                        <label>Value (Number of coins student will get for the artifacts)*:</label><br>
                        <input type="text" value="500"><br>                        
                        <label>Type (Single or Team):</label><br>
                        <select class= "type-seletor" id="type-selector">
                            <option>Single</option>
                            <option>Team</option>
                        </select>
                    </div>
                </div>
                <div class="lower-section">
                    <p>*- Fields marked like the need to be filled to add new entry</p>
                    <button class="btn" id="update-admin">Update</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
    <script>
        document.getElementsByClassName('artifacts-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>

</html>