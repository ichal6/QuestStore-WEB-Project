<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/mentor_dashboard.css">
    <title>Dashboard</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />
        <div class="options_container">
            <div class="options_rectangle">
                <div class="upper_section">
                    <img src="../assets/icons/students_svg.svg" alt="students_icon" class="students_icon">
                    <div class="title_section">
                        <div><p>Students in CC:</p></div>
                        <div class="number" id="students_number"><p>3992</p></div>
                    </div>
                </div>
                <div class="lower_section">
                    <p><a href="codecoolers_list.jsp">See list of Codecoolers...</a></p>
                </div>
            </div>
            <div class="options_rectangle">
                <div class="upper_section">
                    <img src="../assets/icons/classes_svg.svg" alt="classes_icon" class="classes_icon">
                    <div class="title_section">
                        <div><p>Classes in CC:</p></div>
                        <div class="number" id="classes_number"><p>33</p></div>
                    </div>
                </div>
                <div class="lower_section">
                    <p><a href="classes_list.jsp">See list of classes...</a></p>
                </div>
            </div>
            <div class="options_rectangle">
                <div class="upper_section">
                    <img src="../assets/icons/teams_svg.svg" alt="teams_icon" class="teams_icon">
                    <div class="title_section">
                        <div><p>Teams in CC:</p></div>
                        <div class="number" id="teams_number"><p>210</p></div>
                    </div>
                </div>
                <div class="lower_section">
                    <p><a href="teams_list.jsp">See list of teams...</a></p>
                </div>
            </div>
            <div class="options_rectangle">
                <div class="upper_section">
                    <img src="../assets/icons/quests_svg.svg" alt="quests_icon" class="quest_icon">
                    <div class="title_section">
                        <div><p>Possible quests:</p></div>
                        <div class="number" id="quests_number"><p>111</p></div>
                    </div>
                </div>
                <div class="lower_section">
                    <p><a href="quests_list.jsp">See list of quests...</a></p>
                </div>
            </div>
            <div class="options_rectangle">
                <div class="upper_section">
                    <img src="../assets/icons/artifacts_svg.svg" alt="artifacts_icon" class="artifacts_icon">
                    <div class="title_section">
                        <div><p>Available artifacts:</p></div>
                        <div class="number" id="artifacts_number"><p>124</p></div>
                    </div>
                </div>
                <div class="lower_section">
                    <p><a href="artifacts_list.jsp">See list of artifacts...</a></p>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="footer">
            <img src="../assets/icons/codecool_logo_white.png" alt="Codecool logo">
            <p>©2020 - All rights reserved by Karolina, Michał, Michał and Rafał</p>
        </div>
    </footer>
</body>

</html>