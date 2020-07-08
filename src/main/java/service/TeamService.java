package service;

import exception.DateFormatException;
import exception.StringLengthFormatException;
import exception.ValueFormatException;
import model.Quest;
import model.Team;
import validation.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class TeamService {
    private final Validator validator;

    public TeamService() {
        this.validator = new Validator();
    }

    public boolean callInputsValidation(HttpServletRequest request) {
        boolean isInputValid = true;
        isInputValid = callNameValidation(request, isInputValid, 3, 25);
        isInputValid = callCityValidation(request, isInputValid, 3, 25);
        isInputValid = callDateValidation(request, isInputValid, "yyyy-mm-dd");

        return isInputValid;
    }

    public Team extractTeamFromHTTPRequest(HttpServletRequest request) {
        String name = request.getParameter("team-name");
        String city = request.getParameter("team-city");
        Date date = Date.valueOf(request.getParameter("team-start-date"));

        return new Team.Builder()
                .withName(name)
                .withCity(city)
                .withStartDate(date)
                .build();
    }

    private boolean callNameValidation(HttpServletRequest request, boolean isInputValid, int min, int max) {
        try {
            validator.validateStringLength(request.getParameter("team-name"), min, max);
        } catch (StringLengthFormatException e) {
            request.setAttribute("name_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private boolean callCityValidation(HttpServletRequest request, boolean isInputValid, int min, int max) {
        try {
            validator.validateStringLength(request.getParameter("team-city"), min, max);
        } catch (StringLengthFormatException e) {
            request.setAttribute("city_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private boolean callDateValidation(HttpServletRequest request, boolean isInputValid, String allowedFormat) {
        try {
            validator.validateDate(request.getParameter("team-start-date"), allowedFormat);
        } catch (DateFormatException e) {
            request.setAttribute("start_date_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }
}
