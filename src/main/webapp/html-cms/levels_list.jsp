<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/all-persons.css">
    <title>Levels list</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />
    
    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="all-persons-container">
            <div class="upper-section">
                <div class="h1-button">
                    <h1>All levels</h1>
                    <button class="btn" onclick="location.href='levels_add_new.jsp'">+ Add new level</button>
                </div>
                <div class="right-section">
                    <p>Items per page</p>
                </div>
            </div>
            <div class="list-of-persons">
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
                        <span>Description snippet:</span>
                        <div class="arrows">
                            <img src="../assets/img/arrow-up.svg" alt="">
                            <img src="../assets/img/arrow-down.svg" alt="">
                        </div>
                    </div>
                    <div class="coins-div">
                        <span>No. coins to get:</span>
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
                 <div class="person-row">
                    <div class="person-number">1.</div>
                    <div class="person-img-name">
                        <img src="../assets/img/levels-img/level1.svg" alt="person's-image" class="person-img">
                        <p class="person-name">Level I - Iron Maiden</p>
                    </div>
                    <div class="level-description">Lorem ipsumLorem ipsumLorem ipsumLorem ipsumLorem ipsum  </div>
                    <div class="coins-number">200</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="levels_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
                 <div class="person-row">
                    <div class="person-number">2.</div>
                    <div class="person-img-name">
                        <img src="../assets/img/levels-img/level2.svg" alt="person's-image" class="person-img">
                        <p class="person-name">Level II - Silver Warrior</p>
                    </div>
                    <div class="level-description">Lorem ipsumLorem ipsumLorem ipsumLorem ipsumLorem ipsum  </div>
                    <div class="coins-number">500</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="levels_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
                 <div class="person-row">
                    <div class="person-number">3.</div>
                    <div class="person-img-name">
                        <img src="../assets/img/levels-img/level3.svg" alt="person's-image" class="person-img">
                        <p class="person-name">Level III - Golden Blabla</p>
                    </div>
                    <div class="level-description">Lorem ipsumLorem ipsumLorem ipsumLorem ipsumLorem ipsum  </div>
                    <div class="coins-number">1000</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="levels_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
                 <div class="person-row">
                    <div class="person-number">4.</div>
                    <div class="person-img-name">
                        <img src="../assets/img/levels-img/level4.svg" alt="person's-image" class="person-img">
                        <p class="person-name">Level IV - Platinium Cool</p>
                    </div>
                    <div class="level-description">Lorem ipsumLorem ipsumLorem ipsumLorem ipsumLorem ipsum  </div>
                    <div class="coins-number">2500</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="levels_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
                 <div class="person-row">
                    <div class="person-number">5.</div>
                    <div class="person-img-name">
                        <img src="../assets/img/levels-img/level5.svg" alt="person's-image" class="person-img">
                        <p class="person-name">Level V - Stealth Ninja</p>
                    </div>
                    <div class="level-description">Lorem ipsumLorem ipsumLorem ipsumLorem ipsumLorem ipsum  </div>
                    <div class="coins-number">5000</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="levels_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
                 <div class="person-row">
                    <div class="person-number">6.</div>
                    <div class="person-img-name">
                        <img src="../assets/img/levels-img/level6.svg" alt="person's-image" class="person-img">
                        <p class="person-name">Level VI - Codecool Buddha</p>
                    </div>
                    <div class="level-description">Lorem ipsumLorem ipsumLorem ipsumLorem ipsumLorem ipsum  </div>
                    <div class="coins-number">10000</div>
                    <div class="date-of-add">11/07/2019</div>
                    <div class="actions">
                        <a href="levels_update.jsp"><img src="../assets/img/edit-btn.svg" alt="edit-btn"></a>
                       <a href="#"><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                 </div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
    <script>
        document.getElementsByClassName('levels-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>

</html>