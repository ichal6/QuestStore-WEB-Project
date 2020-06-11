<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" onclick="return hideSubMenu()">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='icon' href='../favicon.ico' type='image/x-icon'>
    <link rel="stylesheet" href="../css/codecoolers_update.css">
    <link rel="stylesheet" href="../css/nav.css">
    <title>Update Codecoolers Details</title>
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
                    <li id="select-page"><a href="codecoolers_list.jsp"><img src="../assets/icons/codecoolers_icon.png" alt="codecoolers-icon">Codecoolers</a></li>
                    <li><a href="classes_list.jsp"><img src="../assets/icons/classes_icon.png" alt="classes-icon">Classes</a></li>
                    <li><a href="teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
                    <li><a href="quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
                    <li><a href="artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li>
                </ul>
            </div>
        </aside>
        <div class="details-container"> 

            <h1>Codecoolers's details</h1>
            <a href="codecoolers_list.jsp">&#60;- Back to the list</a>
            <div class="personal-details">
                <h2>Basic details</h2>

                    <div class ="details">
                        
                        <div class="person"> Name*: <br><input type="text" id="person-name" placeholder=""></div>
                        <div class="person"> Class:<br>  
                            <select class= "class-team-seletor" id="class-selector">
                                <option> KRK-JAVA-2020</option>
                                <option> KRK-WEEKEND-2019</option>
                                <option> KRK-WEEKEND-2020</option>
                                <option> WAW-PYTHON-2019</option>
                            </select>
                        </div>
                        <div class="person"> Email*:<br><input type="text" id="person-email" placeholder=""></div>
                        <div class="person"> Team:<br>  
                            <select class= "class-team-seletor" id="team-selector">
                                <option> Andrzej-Marta-Mariusz-Kuba</option>
                                <option> Michał-Rafał-Michał-Karolina</option>
                                <option> Jolanta-Szymon-Mariusz</option>
                            </select>
                        </div>
                        <div class="person"> City:<br> <input type="text" id="person-city" placeholder=""></div>
                        <div class="lower-section">
                            <p>*- Fields marked like these need to be filled to add new entry<br></p>
                            <button class="btn" id="update-admin">Update</button>
                        </div>
                </div>
            </div>

            <div class="personal-details">
                <h2>Wallet Summary</h2>
                <div class="personal-wallet-details">

                        <div class="person-coins-earned">Coins earned in total: </div>
                        <div class="person-coins-earned">2340</div>
                        <div class="person-coins">Coins currently in wallet</div>
                        <div class="person-coins" >400</div>
                        <div class="person-level">Level: </div>
                        <div class="person-level"> VII - The One To Rule Them All  </div>
                        <div class="person-quests">Number of achived quests:  </div>
                        <div class="person-quests" > 5 </div>
                        <div class="person-coins-earned">Number of bought artifacts: </div>
                        <div class="person-coins-earned">5</div>
                        <div class="person-coins-earned">Number of used artifacts: </div>
                        <div class="person-coins-earned">2</div>
                    </div>
            </div>

            <div class="personal-details">
                <h2>Achived quests </h2>
       
                    <div class="list-of-artifacts">
                        <div class="header-for-list">
                            <span></span>
                            <div class="name-div"><span>Name:</span></div>
                            <div class="type-div"><span>Type:</span></div>
                            <div class="when-div"><span>When:</span></div>
                            <div class="earned-div"><span>Earned coins:</span></div>
                            <div class="actions"><span>Actions:</span></div>
                        </div>
                    </div>
                    <div class="quest-details">
                        <div class="quest-number">1.</div>
                        <div class="quest-name">Spot a major mistake in the assignment</div>
                        <div class="quest-type">Basic</div>
                        <div class="quest-date">11/07/2020</div>
                        <div class="class">50</div>
                        <div class="actions">
                            <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                        </div>
                     </div>
                     <div class="quest-details">
                        <div class="quest-number">2.</div>
                        <div class="quest-name">Spot a major mistake in the assignment</div>
                        <div class="quest-type">Basic</div>
                        <div class="quest-date">11/07/2020</div>
                        <div class="class">50</div>
                        <div class="actions">
                            <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                        </div>
                     </div>
                     <div class="quest-details">
                        <div class="quest-number">3.</div>
                        <div class="quest-name">Spot a major mistake in the assignment</div>
                        <div class="quest-type">Basic</div>
                        <div class="quest-date">11/07/2020</div>
                        <div class="class">50</div>
                        <div class="actions">
                            <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                        </div>
                     </div>
                     <div class="quest-details">
                        <div class="quest-number">4.</div>
                        <div class="quest-name">Spot a major mistake in the assignment</div>
                        <div class="quest-type">Basic</div>
                        <div class="quest-date">11/07/2020</div>
                        <div class="class">50</div>
                        <div class="actions">
                            <img src="../assets/img/delete-btn.svg" alt="delete-btn">
                        </div>
                     </div>
                     <div class="add-new-achivement">
                         <label class="achivement">Add new achivement</label>
                        <select class="achivement selector">
                            <option> MartaMariuszMichał Tictactoe</option>
                            <option> BrakNazwy Team</option>
                        </select>
                     
                     <div class="button-position"> <button class="btn" id="add-new">Add new</button></div>
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
                                <option>Used</option>
                                <option>Not Used</option>
                            </select>
                        </div>
                     </div>

                     <div class="button-position"> <button class="btn" id="save-changes">Save changes</button></div>
            </div>
        </div>
    </div>

    <jsp:include page="../html-common/footer.html" />
</body>
</html>