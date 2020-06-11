<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/all-artifacts.css">
    <title>All artifacts</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

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

    <jsp:include page="../html-common/footer.html" />
</body>

</html>