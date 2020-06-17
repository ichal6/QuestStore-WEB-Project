package Controller;

import DAO.PropertiesReader;
import Model.SummaryAdmin;
import Model.SummaryMentor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@WebServlet(name = "Summary", urlPatterns = "/dashboard")

public class SummaryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isAdmin = SessionManager.getActualUser().isAdmin();
        try {
            if (isAdmin) {
                forwardToDashboardAdmin(req, resp);
            } else {
                forwardToDashboardMentor(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void forwardToDashboardMentor(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        SummaryMentor summaryMentor = getSummaryMentor();
        req.setAttribute("summaryMentor", summaryMentor);
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/dashboard_mentor.jsp");
        dispatcher.forward(req, resp);
    }

    private void forwardToDashboardAdmin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        SummaryAdmin summaryAdmin = getSummaryAdmin();
        req.setAttribute("summaryAdmin", summaryAdmin);
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/html-cms/dashboard_admin.jsp");
        dispatcher.forward(req, resp);
    }

    private Connection connectToDB() throws IOException, SQLException {
        Properties prop = PropertiesReader.readProperties("src/main/resources/database.properties");
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.passwd");
        
        return DriverManager.getConnection(url, user, password);
    }

    private SummaryMentor getSummaryMentor() throws SQLException, IOException {
        Connection connectionToDB = connectToDB();
        Statement statement = connectionToDB.createStatement();

        return new SummaryMentor(
                getCodecoolersCount(statement),
                getClassesCount(statement),
                getTeamsCount(statement),
                getQuestsCount(statement),
                getArtifactsCount(statement)
        );
    }

    private SummaryAdmin getSummaryAdmin() throws SQLException, IOException {
        Connection connectionToDB = connectToDB();
        Statement statement = connectionToDB.createStatement();

        return new SummaryAdmin(
                getCodecoolersCount(statement),
                getClassesCount(statement),
                getTeamsCount(statement),
                getQuestsCount(statement),
                getArtifactsCount(statement),
                getAdminsCount(statement),
                getMentorsCount(statement),
                getLevelsCount(statement)
        );
    }

    private int getCodecoolersCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM codecooler; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getClassesCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM class; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getTeamsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM team; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getQuestsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM quest; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getArtifactsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM artifact; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getAdminsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM cms_user WHERE is_admin='t'; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getMentorsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM cms_user WHERE is_admin='f';");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }

    private int getLevelsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM level; ");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }
}
