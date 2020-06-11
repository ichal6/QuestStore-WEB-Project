<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/all-teams.css">
    <title>All teams</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />
    
    <div class="container">
        <aside>
            <div class="nav">
                <ul class="nav-menu">
                    <li><a href="dashboard.jsp"><img src="../assets/icons/home_icon.png" alt="home-icon">Dashboard</a></li>
                    <li><a href="admins_list.jsp"><img src="../assets/icons/admins_icon.png" alt="admin-icon">Admins</a></li>
                    <li><a href="mentors_list.jsp"><img src="../assets/icons/mentors_icon.png" alt="mentors-icon">Mentors</a></li>
                    <li><a href="levels_list.jsp"><img src="../assets/icons/levels_icon.png" alt="levels-icon">Levels</a></li>
                    <li><a href="codecoolers_list.jsp"><img src="../assets/icons/codecoolers_icon.png" alt="codecoolers-icon">Codecoolers</a></li>
                    <li><a href="classes_list.jsp"><img src="../assets/icons/classes_icon.png" alt="classes-icon">Classes</a></li>
                    <li id="select-page"><a href="teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
                    <li><a href="quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
                    <li><a href="artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li></ul>
            </div>
        </aside>
        <div class="all-teams-container">
            <div class="upper-section">
                <div class="h1-button">
                    <h1>All Teams</h1>
                    <button onclick="location.href='teams_add_new.jsp'" type="button" class="btn">+ Add new team</button>
                </div>
                <div class="right-section">
                    <p>Items per page</p>
                </div>
            </div>
            <div class="list-of-teams">
                <div class="header-for-list">
                    <span></span>
                    <div class="name-div">
                        <span>Name:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="city-div">
                        <span>City:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="date-of-start-div">
                        <span>Start date:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="actions-div">
                        <span>Actions:</span>
                    </div>
                </div>
                <div class="team-row">
                   <div class="team-number">1.</div>
                   <div class="team-img-name">
                        <p class="team-name">Example team one</p>
                   </div>
                   <div class="team-city">Cracow</div>
                   <div class="date-of-add">11/07/2019</div>
                   <div class="actions">
                       <a href="teams_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                   </div>
                </div>
                <div class="team-row">
                    <div class="team-number">2.</div>
                    <div class="team-img-name">
                        <p class="team-name">Example team two</p>
                    </div>
                    <div class="team-city">Cracow</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="teams_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
                 <div class="team-row">
                    <div class="team-number">3.</div>
                    <div class="team-img-name">
                        <p class="team-name">Example team three</p>
                    </div>
                    <div class="team-city">Cracow</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="teams_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
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