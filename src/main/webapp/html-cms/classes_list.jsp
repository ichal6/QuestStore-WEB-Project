<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/all-classes.css">
    <title>All classes</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />
    
    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

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

    <jsp:include page="../html-common/footer.html" />
    <script>
        document.getElementsByClassName('classes-nav')[0].setAttribute('id', 'select-page');
    </script>
</body>

</html>