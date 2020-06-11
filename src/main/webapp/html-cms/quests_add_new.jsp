<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/quest_update.css">
    <title>Add new quest</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Add new quest</h1>
            <a href="quests_list.jsp">&#60;- Back to the list</a>
            <div class="quest-details">
                <h2>Basic details</h2>
                <label for="quest-name">Name*:</label>
                <input type="text" id="quest-name">
                <label for="quest-descripton">Description*:</label>
                <textarea id="quest-descripton"></textarea> 
                <div class="proporties-section">
                    <div class="picture">
                        <p>Picture: </p>
                        <a href="#"><img src="../assets/icons/change_picture.svg" alt=" ">Add the picture</a> 
                    </div>
                    <div class=proporties>
                        <label>Value (Number of coins student will get for the quest)*:</label><br>
                        <input type="text"><br>                        
                        <label>Type (Basic or Extra):</label><br>
                        <select class= "type-seletor" id="type-selector">
                            <option value="" selected disabled hidden>Choose...</option>
                            <option> Basic</option>
                            <option> Extra</option>
                        </select>
                    </div>
                </div>
                <div class="lower-section">
                    <p>*- Fields marked like the need to be filled to add new entry</p>
                    <button class="btn" id="add-new-quest">Add new quest</button>
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