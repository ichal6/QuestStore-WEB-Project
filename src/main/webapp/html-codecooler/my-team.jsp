<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Codecool portal - your team's details</title>
  <meta name="my-team" content="Team page">
  <link rel='icon' href='../favicon.ico' type='image/x-icon'>
  <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@600&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="../css/codecooler_my-team.css">
  <link rel="stylesheet" href="../css/codecooler_header.css">
  <link rel="stylesheet" href="../css/codecooler_footer.css">
</head>
<body>
    <header>
        <div class="header-top">
            <div class="social-media">
                <a href="https://www.facebook.com/CodecoolPoland/" id="fb-logo"><img src="../assets/img/social-media/FB-logo.svg" alt="FB"></a>
                <a href="https://www.linkedin.com/school/codecool/" id="linkedin-logo"><img src="../assets/img/social-media/LinkedIn-logo.svg" alt="LinkedIn"></a>
                <a href="https://www.youtube.com/channel/UCFjOIWV4vfIwJltWe3ytZAQ?view_as=subscriber" id="yt-logo"><img src="../assets/img/social-media/Youtube-logo.svg" alt="YouTube"></a>
                <a href="https://www.instagram.com/codecool_official/" id="instagram-logo"><img src="../assets/img/social-media/Instagram-logo.svg" alt="Instagram"></a>
                <a href="https://twitter.com/CodecoolPoland" id="twitter-logo"><img src="../assets/img/social-media/Twitter-logo.svg" alt="Twitter"></a>
            </div>
            <a href="dashboard.jsp"><img src="../assets/img/codequest_logo.svg" alt="logo" class="logo"></a>
            <div class="right-position">
                <p>Jan Codecoolerowy</p><a href="profile.jsp" id="profil"><img src="../assets/icons/codecooler_icon.svg" alt="icon"></a>
                <p>1200</p><a href="profile.jsp#acctual-account" id="coins"> <img src="../assets/icons/money_icon.svg" alt="icon"></a>
            </div>
        </div>
        
        <nav>
            <a href="quests.jsp">QUESTS</a>
            <a href="artifacts.jsp">ARTIFACTS</a>
            <a id="blue-text" href="my-team.jsp"> MY TEAM</a>
        </nav>
    </header>

    <div class="content">

        <div class="level-1">
            <img src="../assets/img/mountains.svg" alt="photo-1">
            <div class="texts">
                <div class="text blue">ENJOY IT TOGETHER!</div>
                <div class="text simple">If you gained enough coins for CC quests,
                 you can exchange them for amazing artifacts. See the list below!</div>
            </div>
        </div>

        <div class="level-2">
            <div class="level-2-text">
                <h1>Basic info:</h1>
                <div class="team-name">Super_team_name</div>
                
                <h2>Team members:</h2>
                <div class="users">
                    <div class="user">
                        <p class="name">Magda</p>
                        <p class="surname">Fiołek</p>
                        <img src="../assets/img/user-photo.svg" alt="user-photo">
                        <div class="description">
                            <p>Balance:</p>
                            <p class="price"><img  src="../assets/icons/money_icon.svg" alt="money-icon">1500 CC</p>
                        </div>
                    </div>
                    
                    <div class="user">
                        <p class="name">Magda</p>
                        <p class="surname">Fiołek</p>
                        <img src="../assets/img/user-photo.svg" alt="user-photo">
                        <div class="description">
                            <p>Balance:</p>
                            <p class="price"><img  src="../assets/icons/money_icon.svg" alt="money-icon">1000 CC</p>
                        </div>
                    </div>

                    <div class="user">
                        <p class="name">Magda</p>
                        <p class="surname">Fiołek</p>
                        <img src="../assets/img/user-photo.svg" alt="user-photo">
                        <div class="description">
                            <p>Balance:</p>
                            <p class="price"><img  src="../assets/icons/money_icon.svg" alt="money-icon">100 CC</p>
                        </div>
                    </div>

                    <div class="user">
                        <p class="name">Magda</p>
                        <p class="surname">Fiołek</p>
                        <img src="../assets/img/user-photo.svg" alt="user-photo">
                        <div class="description">
                            <p>Balance:</p>
                            <p class="price"><img  src="../assets/icons/money_icon.svg" alt="money-icon">0 CC</p>
                        </div>
                    </div>
                </div>

                <h2>Your total ammount of coins:</h2>
                <div id="acctual-account"><img src="../assets/icons/money_icon_white.svg" alt="money-icon"> 2600 CC</div>

            </div>
        </div>

        <div class="level-3">
            <div class="level-3-text">
                <h1>Bought artifacts:</h1>

                <div class="items">
                    <div class="item">
                        <p class="title">Your team works from home for a day</p>
                        <img src="../assets/img/work-hard-no-shadow.svg" alt="work-hard">
                        <p>If you spot the bug, please contact your mentor.
                             He will give you your points if the bug is relevant
                        </p>
                        <p class="price">100 CC</p>
                        <p class="date-buy">10.06.2019</p>
                        <p class="available">AVAILABLE</p>
                    </div>

                    <div class="item">
                        <p class="title">Your Mentors come to school dressed as pirates</p>
                        <img src="../assets/img/work-hard-no-shadow.svg" alt="work-hard">
                        <p>If you spot the bug, please contact your mentor.
                             He will give you your points if the bug is relevant
                        </p>
                        <p class="price">100 CC</p>
                        <p class="date-buy">10.06.2019</p>
                        <p class="used">USED</p>
                    </div>

                </div>
            </div>
        </div>

        <div class="level-4">
            <div class="level-4-text">
                <h1>CAN YOU AFFORD MORE?</h1>
                <p>Th price of each artifact is splitted equally between all group members,
                     so each member needs to have enough coins co contribute.
                </p>

                <button onclick="location.href='artifacts.jsp'" type="button" class="button-red">See available artifacts</button>
            </div>
        </div>
    </div>

    <footer class="footer">

        <div class="footer-logo">  <img src="../assets/img/codecool_logo_white.png" alt="logo"> </div>
        
        <div class="footer-text">
            <p> ©2020 All rights reserved by Karolina, Michał, Michał and Rafał</p>

        </div>
    </footer>
</body>
</html>