package Controller;

import DAO.LoginData;
import Model.SummaryAdmin;
import Model.SummaryMentor;

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
    private Connection connectionToDB = null;

    private Connection connectToDB() throws IOException {
        Properties prop = LoginData.readProperties("src/main/resources/database.properties");
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.passwd");
        try {
            connectionToDB = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }
        return connectionToDB;
    }

    private SummaryMentor getSummaryMentor() throws SQLException {
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        Statement statement = connectionToDB.createStatement();
        SummaryMentor summaryMentor = new SummaryMentor(
                getCodecoolersCount(statement),
                getClassesCount(statement),
                getTeamsCount(statement),
                getQuestsCount(statement),
                getArtifactsCount(statement)
        );


        return summaryMentor;
    }

    private int getCodecoolersCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from codecooler; ");
        return resultSet.getInt(1);
    }

    private int getClassesCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from class; ");
        return resultSet.getInt(1);
    }

    private int getTeamsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from team; ");
        return resultSet.getInt(1);
    }

    private int getQuestsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from quest; ");
        return resultSet.getInt(1);
    }

    private int getArtifactsCount(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from artifact; ");
        return resultSet.getInt(1);
    }

    private SummaryAdmin getSummaryAdmin() {
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isAdmin = SessionManager.getActualUser().isAdmin();

        try {
            if (isAdmin) {
                getSummaryAdmin();

            } else {
                getSummaryMentor();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
