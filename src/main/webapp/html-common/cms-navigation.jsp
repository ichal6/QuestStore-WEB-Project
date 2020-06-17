<%@ page import="Controller.SessionManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/nav.css">
    <title>Title</title>
</head>
<body>

<%
    String role = SessionManager.getActualUser().getRole();
%>

<aside>
    <%
        if (role.toLowerCase().equals("admin")) {
    %>
    <div class="nav">
        <ul class="nav-menu">
            <li class="dashboard-nav"><a href="/dashboard"><img src="../assets/icons/home_icon.png" alt="home-icon">Dashboard</a></li>
            <li class="admins-nav"><a href="../html-cms/admins_list.jsp"><img src="../assets/icons/admins_icon.png" alt="admin-icon">Admins</a></li>
            <li class="mentors-nav"><a href="../html-cms/mentors_list.jsp"><img src="../assets/icons/mentors_icon.png" alt="mentors-icon">Mentors</a></li>
            <li class="levels-nav"><a href="/levels"><img src="../assets/icons/levels_icon.png" alt="levels-icon">Levels</a></li>
            <li class="codecoolers-nav"><a href="../html-cms/codecoolers_list.jsp"><img src="../assets/icons/codecoolers_icon.png" alt="codecoolers-icon">Codecoolers</a></li>
            <li class="classes-nav"><a href="../html-cms/classes_list.jsp"><img src="../assets/icons/classes_icon.png" alt="classes-icon">Classes</a></li>
            <li class="teams-nav"><a href="../html-cms/teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
            <li class="quests-nav"><a href="../html-cms/quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
            <li class="artifacts-nav"><a href="../html-cms/artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li>
        </ul>
    </div>

    <%
        } else if (role.toLowerCase().equals("mentor")) {
    %>

    <div class="nav">
        <ul class="nav-menu">
            <li class="dashboard-nav"><a href="/dashboard"><img src="../assets/icons/home_icon.png" alt="home-icon">Dashboard</a></li>
            <li class="codecoolers-nav"><a href="../html-cms/codecoolers_list.jsp"><img src="../assets/icons/codecoolers_icon.png" alt="codecoolers-icon">Codecoolers</a></li>
            <li class="classes-nav"><a href="../html-cms/classes_list.jsp"><img src="../assets/icons/classes_icon.png" alt="classes-icon">Classes</a></li>
            <li class="teams-nav"><a href="../html-cms/teams_list.jsp"><img src="../assets/icons/teams_icon.png" alt="teams-icon">Teams</a></li>
            <li class="quests-nav"><a href="../html-cms/quests_list.jsp"><img src="../assets/icons/quests_icon.png" alt="quests-icon">Quests</a></li>
            <li class="artifacts-nav"><a href="../html-cms/artifacts_list.jsp"><img src="../assets/icons/artifacts_icon.png" alt="artifacts-icon">Artifacts</a></li>
        </ul>
    </div>

    <%
        }
    %>
</aside>
</body>
</html>

<%--id="select-page" - dla podświetlonego obiektu--%>