<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/teams_add_new.css">
    <title>Add new team</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container"> 

            <h1>Add new team</h1>
            <a href="teams_list.jsp">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details</h2>

                    <div class ="details">
                        
                        <div class="person"> Name*: <input type="text" id="person-name" placeholder=""></div>
                        <div class="person"> City: <input type="text" id="person-city" placeholder=""></div>
                        <div class="person"> Start date*:<input type="text" id="person-start-date" placeholder=""></div>
                    
                        <div class="lower-section">
                            <p>*- Fields marked like these need to be filled to add new entry</p>
                            <button class="btn" id="update-admin">Add new</button>
                        </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
    <script>
        document.getElementsByClassName('teams-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>
</html>