<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/all-quests.css">
    <title>List of quests</title>
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
                    <li><a href="teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
                    <li id="select-page"><a href="quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
                    <li><a href="artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li></ul>
            </div>
        </aside>
        <div class="all-quests-container">
            <div class="upper-section">
                <div class="h1-button">
                    <h1>All quests</h1>
                    <button class="btn" onclick="location.href='quests_add_new.jsp'">+ Add new quest</button>
                </div>
                <div class="right-section">
                    <p>Items per page</p>
                </div>
            </div>
            <div class="list-of-quests">
                <div class="header-for-list">
                    <span></span>
                    <div class="name-div">
                        <span>Name:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="description-div">
                        <span>Description snippet</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="value-div">
                        <span>Value:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="type-div">
                        <span>Type:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="date-of-adding-div">
                        <span>Date of adding:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="^">
                            <img src="../assets/img/arrow-down.svg" alt="v">
                        </div>
                    </div>
                    <div class="actions-div">
                        <span>Actions:</span>
                    </div>
                </div>
                <div class="quest-row">
                    <div class="quest-number">1.</div>
                    <div class="quest-img-name">
                        <img src="../assets/img/quest_logo_01.svg" alt="quest's-image"
                            class="quest-img">
                        <p class="quest-name">Passing a Checkpoint</p>
                    </div>
                    <div class="quest-descriptions">You’ve passed the checkpoint and got to next...</div>
                    <div class="quest-value">500</div>
                    <div class="quest-type">Basic</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="quests_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="quest-row">
                    <div class="quest-number">2.</div>
                    <div class="quest-img-name">
                        <img src="../assets/img/quest_logo_02.svg" alt="quest's-image"
                            class="quest-img">
                        <p class="quest-name">Spot a mistake in the assignment </p>
                    </div>
                    <div class="quest-descriptions">You’re super cool and awesome and can be...</div>
                    <div class="quest-value">500</div>
                    <div class="quest-type">Extra</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="quests_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="quest-row">
                    <div class="quest-number">3.</div>
                    <div class="quest-img-name">
                        <img src="../assets/img/quest_logo_03.svg" alt="quest's-image"
                            class="quest-img">
                        <p class="quest-name">Do a demo for the class</p>
                    </div>
                    <div class="quest-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="quest-value">1000</div>
                    <div class="quest-type">Extra</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="quests_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="quest-row">
                    <div class="quest-number">4.</div>
                    <div class="quest-img-name">
                        <img src="../assets/img/quest_logo_04.svg" alt="quest's-image"
                            class="quest-img">
                        <p class="quest-name">Take part in student screening...</p>
                    </div>
                    <div class="quest-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="quest-value">5000</div>
                    <div class="quest-type">Extra</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="quests_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="quest-row">
                    <div class="quest-number">5.</div>
                    <div class="quest-img-name">
                        <img src="../assets/img/quest_logo_05.svg" alt="quest's-image"
                            class="quest-img">
                        <p class="quest-name">Attend one month without being...</p>
                    </div>
                    <div class="quest-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="quest-value">10000</div>
                    <div class="quest-type">Extra</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="quests_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>

                <div class="quest-row">
                    <div class="quest-number">6.</div>
                    <div class="quest-img-name">
                        <img src="../assets/img/quest_logo_06.svg" alt="quest's-image"
                            class="quest-img">
                        <p class="quest-name">Set a SMART goal with your tutor...</p>
                    </div>
                    <div class="quest-descriptions">Loremskskdkfkfkfkf kfkffkfkfk fk  kfkfkfkfk...</div>
                    <div class="quest-value">10000</div>
                    <div class="quest-type">Extra</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="quests_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
</body>

</html>