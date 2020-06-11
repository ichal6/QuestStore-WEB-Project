<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/codecoolers_update.css">
    <title>Add new Codecooler</title>
</head>

    <body>
    <jsp:include page="../html-common/cms-header.jsp"/>

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">

            <h1>Add new Codecooler</h1>
            <a href="codecoolers_list.jsp">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details</h2>

                <div class="details">

                    <div class="person"> Name*: <br><input type="text" id="person-name" placeholder=""></div>
                    <div class="person"> Class:<br>
                        <select class="class-team-seletor" id="class-selector">
                            <option value="" disabled selected>Choose...</option>
                            <option> KRK-JAVA-2020</option>
                            <option> KRK-WEEKEND-2019</option>
                            <option> KRK-WEEKEND-2020</option>
                            <option> WAW-PYTHON-2019</option>
                        </select>
                    </div>
                    <div class="person"> Email*:<br><input type="text" id="person-email" placeholder=""></div>
                    <div class="person"> Team:<br>
                        <select class="class-team-seletor" id="team-selector">
                            <option value="" disabled selected>Choose...</option>
                            <option> Andrzej-Marta-Mariusz-Kuba</option>
                            <option> Michał-Rafał-Michał-Karolina</option>
                            <option> Jolanta-Szymon-Mariusz</option>
                        </select>
                    </div>
                    <div class="person"> City:<br> <input type="text" id="person-city" placeholder=""></div>
                    <div class="lower-section">
                        <p>*- Fields marked like these need to be filled to add new entry<br></p>
                        <button class="btn" id="update-student">Add new Codecooler</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html"/>
</body>
</html>