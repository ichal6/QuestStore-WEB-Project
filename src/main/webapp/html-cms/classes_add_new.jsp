<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/classes_add_new.css">
    <title>Add new class</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Add new class</h1>
            <a href="classes_list.jsp">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details</h2>
                    <div class ="details">
                        
                        <div class="class"> Name*: <br><input type="text" id="class-name"></div>
                        <div class="class"> City: <br><input type="text" id="class-city"></div>
                        <div class="class"> Start date*:<br><input type="text" id="class-start-date"></div>
                        <div class="class"> End date*:<br><input type="text" id="class-end-date"></div>

                        <div class="lower-section">
                            <p>*- Fields marked like these need to be filled to add new class<br></p>
                            <button class="btn" id="update-class">Add class</button>
                        </div>
                    </div>
            </div>
        </div>    
     </div>

    <jsp:include page="../html-common/footer.html" />
</body>
</html>