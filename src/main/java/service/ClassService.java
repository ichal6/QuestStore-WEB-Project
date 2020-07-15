package service;

import DAO.CodecoolerClassDAO;
import model.CodecoolerClass;

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

    public CodecoolerClass changeClassDetails(HttpServletRequest request, CodecoolerClass codecoolerclass) {
        String name = request.getParameter("class-name");
        String city = request.getParameter("class-city");
        Date startDate = Date.valueOf(request.getParameter("class-start-date"));
        Date endDate = Date.valueOf(request.getParameter("class-end-date"));

        codecoolerclass.setName(name);
        codecoolerclass.setCity(city);
        codecoolerclass.setStartDate(startDate);
        codecoolerclass.setEndDate(endDate);

        return codecoolerclass;
    }
}
