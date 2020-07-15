package service;

import DAO.CodecoolerClassDAO;
import DAO.QuestDAO;
import model.CodecoolerClass;
import model.Quest;
import model.Team;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class ClassService {
    private final CodecoolerClassDAO classDAO;

    public ClassService(CodecoolerClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    public CodecoolerClass extractClassFromHTTPRequest(HttpServletRequest request) {
        String name = request.getParameter("class-name");
        String city = request.getParameter("class-city");
        Date startDate = Date.valueOf(request.getParameter("class-start-date"));
        Date endDate = Date.valueOf(request.getParameter("class-end-date"));

        return new CodecoolerClass.Builder()
                .withName(name)
                .withCity(city)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build();
    }
}
