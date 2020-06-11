<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/artifact_update.css">
    <title>Add new artifacts</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Add new artifact</h1>
            <a href="artifacts_list.jsp">&#60;- Back to the list</a>
            <div class="artifacts-details">
                <h2>Basic details</h2>
                <label for="artifacts-name">Name*:</label>
                <input type="text" id="artifacts-name">
                <label for="artifacts-descripton">Description*:</label>
                <textarea id="artifacts-descripton"></textarea> 
                <div class="proporties-section">
                    <div class="picture">
                        <p>Picture: </p>
                        <a href="#"><img src="../assets/icons/change_picture.svg" alt=" ">Add the picture</a> 
                    </div>
                    <div class=proporties>
                        <label>Value (Number of coins student will get for the artifacts)*:</label><br>
                        <input type="text"><br>                        
                        <label>Type (Single or Team):</label><br>
                        <select class= "type-seletor" id="type-selector">
                            <option value="" selected disabled hidden>Choose...</option>
                            <option>Single</option>
                            <option>Team</option>
                        </select>
                    </div>
                </div>
                <div class="lower-section">
                    <p>*- Fields marked like the need to be filled to add new entry</p>
                    <button class="btn" id="add-new-artifact">Add new artifact</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
</body>

</html>