<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/all-classes.css">
    <script src="../js/dropdown.js" ></script>
    <title>All classes</title>
</head>

<body>
    <div class="header">
        <div class="left-position">
            <a href="admin_dashboard.jsp"> <img src="../assets/icons/codecool_logo_color.png" alt="logo" class="logo"></a>
        </div>
        <div class="right-position">
            <a id="name">Jan Kowalski</a>
            <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
            <a id="role">Admin</a>
            <img class="right-position image" src="../assets/icons/user_icon.png" alt="user icon" onmouseover="return displayDropdown()">
            <div id="arrow-up">
        </div>
        </div>
        <div id="dropdown-content">
            <ul>
                <li>
                    <a href="../html-login-and-account/my-account-admin.jsp">My account
                        <img src="../assets/icons/my_account_icon.svg" alt="icon"></a>
                </li>
                <li>
                    <a href="#">Log out
                        <img src="../assets/icons/log_out_icon.svg" alt="icon"></a>
                </li>
            </ul>
        </div>
    </div>
    
    <div class="container">
        <aside>
            <div class="nav">
                <ul class="nav-menu">
                    <li><a href="admin_dashboard.jsp"><img src="../assets/icons/home_icon.png" alt="home-icon">Dashboard</a></li>
                    <li><a href="admins_list.jsp"><img src="../assets/icons/admins_icon.png" alt="admin-icon">Admins</a></li>
                    <li><a href="mentors_list.jsp"><img src="../assets/icons/mentors_icon.png" alt="mentors-icon">Mentors</a></li>
                    <li><a href="levels_list.jsp"><img src="../assets/icons/levels_icon.png" alt="levels-icon">Levels</a></li>
                    <li><a href="codecoolers_list.jsp"><img src="../assets/icons/codecoolers_icon.png" alt="codecoolers-icon">Codecoolers</a></li>
                    <li id="select-page"><a href="classes_list.jsp"><img src="../assets/icons/classes_icon.png" alt="classes-icon">Classes</a></li>
                    <li><a href="teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
                    <li><a href="quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
                    <li><a href="artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li></ul>
            </div>
        </aside>
        <div class="all-classes-container">
            <div class="upper-section">
                <div class="h1-button">
                    <h1>All classes</h1>
                    <button onclick="location.href='classes_add_new.jsp'" class="btn">+ Add new class</button>
                </div>
                <div class="right-section">
                    <p>Items per page</p>
                </div>
            </div>
            <div class="list-of-classes">
                <div class="header-for-list">
                    <span></span>
                    <div class="name-div">
                        <span>Name:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="city-div">
                        <span>City:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="start-date-div">
                        <span>Start date:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="end-date-div">
                        <span>End-date:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="actions-div">
                        <span>Actions:</span>
                    </div>
                </div>
                <div class="class-row">
                   <div class="class-number">1.</div>
                   <div class="class-name">KRK-2020-08-Fullstack-Weekend</div>
                   <div class="class-city">Cracow</div>
                   <div class="class-start-date">11/07/2019</div>
                   <div class="class-end-date">11/07/2020</div>
                   <div class="actions">
                       <a href="classes_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                   </div>
                </div>
                <div class="class-row">
                    <div class="class-number">2.</div>
                    <div class="class-name">KRK-2020-08-Fullstack-Weekdays</div>
                    <div class="class-city">Cracow</div>
                    <div class="class-start-date">11/07/2019</div>
                    <div class="class-end-date">11/07/2020</div>
                    <div class="actions">
                        <a href="classes_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                    </div>
                 </div>
                 <div class="class-row">
                    <div class="class-number">1.</div>
                    <div class="class-name">WAW-2019-JAVA-Weekend</div>
                    <div class="class-city">Warsaw</div>
                    <div class="class-start-date">15/02/2019</div>
                    <div class="class-end-date">11/02/2020</div>
                    <div class="actions">
                        <a href="classes_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                    </div>
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