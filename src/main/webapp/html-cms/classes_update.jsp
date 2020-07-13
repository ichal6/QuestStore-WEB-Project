<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="classToEdit" scope="request" type="model.CodecoolerClass"/>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/classes_add_new.css">
    <title>Class update</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container">
            <h1>Class details</h1>
            <a href="/classes">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details</h2>
                    <div class ="details">
                        
                        <div class="class"> Name*: <br><input type="text" name="class-name" id="class-name" value="${classToEdit.name}"></div>
                        <div class="class"> City: <br><input type="text" name="class-city" id="class-city" value="${classToEdit.city}"></div>
                        <div class="class"> Start date*:<br><input type="text" name="class-start-date" id="class-start-date" value="${classToEdit.startDate}"></div>
                        <div class="class"> End date*:<br><input type="text" name="class-end-date" id="class-end-date" value="${classToEdit.endDate}"></div>

                        <div class="lower-section">
                            <p>*- Fields marked like these need to be filled<br></p>
                            <button class="btn" id="update-class">Update</button>
                        </div>
                    </div>
            </div>

            <div class="personal-details">
                <div class ="details">
                    <h2>Codecoolers in the class</h2>
                </div>

                <div class="codecoolers-in-class">
                    <div class="header-for-list">
                        <div> </div>
                        <div class="name-div">
                            <span>Name:</span>
                        </div>
                        <div class="email-div">
                            <span>Email</span>
                        </div>
                        <div class="actions-div">
                            <span>Actions:</span>
                        </div>

                </div>
                <div class ="class-members">
                    <div class="class-members-number">1</div>
                    <div class="class-members-name">James Bons</div>
                    <div class="class-members-email">james.bond007@gmail.com</div>
                    <div class="actions">
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div> 
                <div class ="class-members">
                    <div class="class-members-number">2</div>
                    <div class="class-members-name">James Bons</div>
                    <div class="class-members-email">james.bond007@gmail.com</div>
                    <div class="actions">
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div> 
                <div class ="class-members">
                    <div class="class-members-number">3</div>
                    <div class="class-members-name">James Bons</div>
                    <div class="class-members-email">james.bond007@gmail.com</div>
                    <div class="actions">
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>
                </div> 

                <div class="add-new-codecooler">
                    <label class="title">Add new Student</label><br>
                   <select class="student-name" id="selector">
                        <option value="" disabled selected>Select Student </option>
                        <option>Grażyna Kowalska</option>
                        <option>Janusz Adamczyk</option>
                        <option>Ewelina Cielińska</option>
                   </select>
                </div>

                <button class="btn" id="add-codecooler">Add new</button>
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