package service;

import exception.StringLengthFormatException;
import exception.TypeFormatException;
import exception.ValueFormatException;
import model.Quest;
import validation.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestService {
    private Validator validator;

    public QuestService() {
        this.validator = new Validator();
    }

    public boolean callInputsValidation(HttpServletRequest request) {
        boolean isInputValid = true;
        isInputValid = callNameValidation(request, isInputValid, 3, 50);
        isInputValid = callDescriptionValidation(request, isInputValid, 3, 100);
        isInputValid = callValueValidation(request, isInputValid, 0, 1000000);
        isInputValid = callTypeValidation(request, isInputValid, "BASIC", "EXTRA");

        return isInputValid;
    }

    public Quest extractQuestFromHTTPRequest(HttpServletRequest request) {
        String name = request.getParameter("quest-name");
        String description = request.getParameter("quest-description");
        int value = Integer.parseInt(request.getParameter("quest-value"));
        String type = request.getParameter("quest-type");
        String url = getRandomUrlPath();

        return new Quest(name, description, value, type, url);
    }

    private boolean callNameValidation(HttpServletRequest request, boolean isInputValid, int min, int max) {
        try {
            validator.validateStringLength(request.getParameter("quest-name"), min, max);
        } catch (StringLengthFormatException e) {
            request.setAttribute("name_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private boolean callDescriptionValidation(HttpServletRequest request, boolean isInputValid, int min, int max) {
        try {
            validator.validateStringLength(request.getParameter("quest-description"), min, max);
        } catch (StringLengthFormatException e) {
            request.setAttribute("description_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private boolean callValueValidation(HttpServletRequest request, boolean isInputValid, int min, int max) {
        try {
            validator.validateValue(request.getParameter("quest-value"), min, max);
        } catch (ValueFormatException e) {
            request.setAttribute("value_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private boolean callTypeValidation(HttpServletRequest request, boolean isInputValid, String type1, String type2) {
        try {
            validator.validateType(request.getParameter("quest-type"), type1, type2);
        } catch (TypeFormatException e) {
            request.setAttribute("type_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private String getRandomUrlPath() {
        List<String> urlPaths = Arrays.asList("quest_logo_01.svg", "quest_logo_02.svg", "quest_logo_03.svg",
                "quest_logo_04.svg", "quest_logo_05.svg", "quest_logo_06.svg");
        Random rand = new Random();

        return urlPaths.get(rand.nextInt(urlPaths.size()));
    }
}
