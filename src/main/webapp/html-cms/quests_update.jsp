<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/quest_update.css">
    <title>Update quest</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Quest's details</h1>
            <a href="quests_list.jsp">&#60;- Back to the list</a>
            <div class="quest-details">
                <h2>Basic details</h2>
                <label for="quest-name">Name*:</label>
                <input type="text" id="quest-name" value="Spot a major mistake in cc assignment">
                <label for="quest-descripton">Description*:</label>
                <textarea id="quest-descripton">You’ve found the mistake that our mentors did, congratulations! Contact your mentor to be rewarded for it!</textarea> 
                <div class="proporties-section">
                    <div class="picture">
                        <p>Picture: </p>
                        <img id="quest-logo" src="../assets/img/quests-img/quest_logo_02.svg" alt="logo of quest"><br>
                        <a href="#"><img src="../assets/icons/change_picture.svg" alt=" ">Change picture</a> 
                    </div>
                    <div class=proporties>
                        <label>Value (Number of coins student will get for the quest)*:</label><br>
                        <input type="text" value="500"><br>                        
                        <label>Type (Basic or Extra):</label><br>
                        <select class= "type-seletor" id="type-selector">
                            <option> Basic</option>
                            <option> Extra</option>
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
        document.getElementsByClassName('quests-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>

</html>