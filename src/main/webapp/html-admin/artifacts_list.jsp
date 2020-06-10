<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/all-artifacts.css">
    <script src="../js/dropdown.js" ></script>
    <title>All artifacts</title>
</head>

<body>
    <div class="header">
        <div class="left-position">
            <a href="admin_dashboard.jsp"><img id="logo" src="../assets/icons/codecool_logo_color.png" alt="Codecool logo"></a>
        </div>
        <div class="right-position">
            <a id="name">Jan Kowalski</a>
            <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
            <a id="role">Admin</a>
            <img class="right-position image" src="../assets/icons/user_icon.png" alt="user icon"
                onmouseover="return displayDropdown()">
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
                    <li><a href="classes_list.jsp"><img src="../assets/icons/classes_icon.png" alt="classes-icon">Classes</a></li>
                    <li><a href="teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
                    <li><a href="quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
                    <li id="select-page"><a href="artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li>
                </ul>
            </div>
        </aside>
        <div class="all-artifacts-container">
            <div class="upper-section">
                <div class="h1-button">
                    <h1>All artifacts</h1>
                    <button onclick="location.href='artifacts_add_new.jsp'" class="btn">+ Add new artifact</button>
                </div>
                <div class="right-section">
                    <p>Items per page</p>
                </div>
            </div>
            <div class="list-of-artifacts">
                <div class="header-for-list">
                    <span></span>
                    <div class="name-div">
                        <span>Name:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="description-div">
                        <span>Description snippet</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="value-div">
                        <span>Value:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="type-div">
                        <span>Type:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="date-of-adding-div">
                        <span>Date of adding:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="actions-div">
                        <span>Actions:</span>
                    </div>
                </div>
                <div class="artifact-row">
                    <div class="artifact-number">1.</div>
                    <div class="artifact-img-name">
                        <img src="../assets/img/artifacts-images/artifacts_1.svg" alt="artifact's-image"
                            class="artifact-img">
                        <p class="artifact-name">Private mentoring</p>
                    </div>
                    <div class="artifact-descriptions">You can ask any of the mentors to spend 1 h...</div>
                    <div class="artifact-value">500</div>
                    <div class="artifact-type">Single</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="artifacts_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="artifact-row">
                    <div class="artifact-number">2.</div>
                    <div class="artifact-img-name">
                        <img src="../assets/img/artifacts-images/artifacts_2.svg" alt="artifact's-image"
                            class="artifact-img">
                        <p class="artifact-name">Spend a day in home office</p>
                    </div>
                    <div class="artifact-descriptions">One day of your choice will be a treat! You...</div>
                    <div class="artifact-value">500</div>
                    <div class="artifact-type">Single</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="artifacts_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="artifact-row">
                    <div class="artifact-number">3.</div>
                    <div class="artifact-img-name">
                        <img src="../assets/img/artifacts-images/artifacts_3.svg" alt="artifact's-image"
                            class="artifact-img">
                        <p class="artifact-name">Extend an SI deadline for week</p>
                    </div>
                    <div class="artifact-descriptions">Didn’t have enough time to finish the assign...</div>
                    <div class="artifact-value">1000</div>
                    <div class="artifact-type">Single</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="artifacts_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="artifact-row">
                    <div class="artifact-number">4.</div>
                    <div class="artifact-img-name">
                        <img src="../assets/img/artifacts-images/artifacts_4.svg" alt="artifact's-image"
                            class="artifact-img">
                        <p class="artifact-name">Take part in student screening...</p>
                    </div>
                    <div class="artifact-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="artifact-value">5000</div>
                    <div class="artifact-type">Team</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="artifacts_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="artifact-row">
                    <div class="artifact-number">5.</div>
                    <div class="artifact-img-name">
                        <img src="../assets/img/artifacts-images/artifacts_5.svg" alt="artifact's-image"
                            class="artifact-img">
                        <p class="artifact-name">Attend one month without being...</p>
                    </div>
                    <div class="artifact-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="artifact-value">10000</div>
                    <div class="artifact-type">Team</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="artifacts_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="artifact-row">
                    <div class="artifact-number">6.</div>
                    <div class="artifact-img-name">
                        <img src="../assets/img/artifacts-images/artifacts_6.svg" alt="artifact's-image"
                            class="artifact-img">
                        <p class="artifact-name">Set a SMART goal with your tutor...</p>
                    </div>
                    <div class="artifact-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="artifact-value">10000</div>
                    <div class="artifact-type">Team</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="artifacts_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
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