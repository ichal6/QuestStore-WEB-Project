<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/teams_add_new.css">
    <title>Team update</title>
</head>

<body>
    <jsp:include page="../html-common/cms-header.jsp" />

    <div class="container">
        <jsp:include page="../html-common/cms-navigation.jsp" />

        <div class="details-container"> 

            <h1>Team details</h1>
            <a href="teams_list.jsp">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details</h2>

                    <div class ="details">
                        
                        <div class="person"> Name*: <input type="text" id="person-name" value="Tomato-TicTacToe-Team"></div>
                        <div class="person"> City: <input type="text" id="person-city" value="Cracow"></div>
                        <div class="person"> Start date*:<input type="text" id="person-start-date" value="05/05/2019"></div>
                    
                        <div class="lower-section">
                            <p>*- Fields marked like these need to be filled</p>
                            <button class="btn" id="update-admin">Update</button>
                        </div>
                </div>

               
            </div>

            <div class="personal-details">
                <div class ="details">
                    <h2>Codecoolers in the team</h2>
                </div>

                <div class="codecoolers-in-team">
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
                <div class ="team-members">
                    <div class="team-members-number">1 </div>
                    <div class="team-members-name">James Bons</div>
                    <div class="team-members-email">james.bond007@gmail.com</div>
                    <div class="actions">
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>

                </div> 
                <div class ="team-members">
                    <div class="team-members-number">2</div>
                    <div class="team-members-name">James Bons</div>
                    <div class="team-members-email">james.bond007@gmail.com</div>
                    <div class="actions">
                        <a href=""><img src="../assets/img/delete-btn.svg" alt="delete-btn"></a>
                    </div>

                </div> 
                <div class ="team-members">
                    <div class="team-members-number">3</div>
                    <div class="team-members-name">James Bons</div>
                    <div class="team-members-email">james.bond007@gmail.com</div>
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
            <div class="personal-details">
                <h2>Bought artifacts</h2>
                <div class="list-of-artifacts">
                    <div class="header-for-list">
                        <span></span>
                        <div class="name-div"><span>Name:</span></div>
                        <div class="type-div"><span>Type:</span></div>
                        <div class="when-div"><span>When:</span></div>
                        <div class="earned-div"><span>Cost:</span></div>
                        <div class="actions"><span>Used/Not Used:</span></div>
                    </div>
                </div>
                <div class="quest-details">
                    <div class="quest-number">1.</div>
                    <div class="quest-name">Private Mentoring</div>
                    <div class="quest-type">Single</div>
                    <div class="quest-date">11/07/2020</div>
                    <div class="class">50</div>
                    <div class="used-not">
                        <select class="selector">
                            <option> Used</option>
                            <option> Not Used</option>
                        </select>
                    </div>
                </div>
                <div class="quest-details">
                    <div class="quest-number">2.</div>
                    <div class="quest-name">Extra material for current topic</div>
                    <div class="quest-type">Team</div>
                    <div class="quest-date">11/07/2020</div>
                    <div class="class">300</div>
                    <div class="used-not">
                        <select class="selector">
                            <option> Used</option>
                            <option> Not Used</option>
                        </select>
                    </div>
                </div>
                <div class="quest-details">
                    <div class="quest-number">1.</div>
                    <div class="quest-name">Private Mentoring</div>
                    <div class="quest-type">Single</div>
                    <div class="quest-date">11/07/2020</div>
                    <div class="class">50</div>
                    <div class="used-not">
                        <select class="selector">
                            <option> Used</option>
                            <option> Not Used</option>
                        </select>
                    </div>
                </div>
                <div class="button-position"> <button class="btn" id="update-quests">Save changes</button></div>
            </div>
     </div>
     </div>

    <jsp:include page="../html-common/footer.html" />
</body>
</html>