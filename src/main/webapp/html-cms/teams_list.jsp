<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/all-teams.css">
    <title>All teams</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />
    
    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

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

    <jsp:include page="../html-common/footer.html" />
    <script>
        document.getElementsByClassName('teams-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>

</html>