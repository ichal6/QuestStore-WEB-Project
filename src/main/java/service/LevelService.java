package service;

import DAO.LevelDAO;
import exception.NoComparatorException;
import exception.ReadException;
import exception.StringLengthFormatException;
import exception.ValueFormatException;
import model.Artifact;
import model.Level;
import sort.*;
import validation.Validator;
import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;


public class LevelService {
    Validator validator = new Validator();
    private LevelDAO dao;

    public LevelService(){

    }

    public LevelService(LevelDAO dao){
        this.dao = dao;
    }

    public List<Level> getAllLevels(String sortBy, Boolean order) throws ReadException {
        List<Level> allLevels = dao.getLevelsList();
        if (order != null && sortBy != null) {
            try {
                allLevels = sortList(allLevels, order, sortBy);
            } catch (NoComparatorException e) {
                throw new ReadException(e.getMessage());
            }
        }
        return allLevels;
    }

    public boolean mainValidator(HttpServletRequest request){

        boolean validateInput = true;


        validateInput = validateInputName(request, validateInput, 3, 25 );
        validateInput = validateInputDescription(request, validateInput, 10, 100);
        validateInput = validateInputCoins(request, validateInput, 1, 10000);


        return validateInput;
    }

    public Level getInformationFromServlet(HttpServletRequest req){
        String name = req.getParameter("level-name");
        String description = req.getParameter("level-description");
        String coins = req.getParameter("level-coins");
        int price = parseInt(coins);

        Level level = new Level(name, description, price, "level6.svg");

        return level;
    }

    public Level getInformationToUpdate(HttpServletRequest request, Level level){
        String name = request.getParameter("level-name");
        String description = request.getParameter("level-description");
        String coins = request.getParameter("level-coins");
        int price = parseInt(coins);

        level.setName(name);
        level.setDescription(description);
        level.setPrice(price);

        return level;

    }

    public boolean validateInputName(HttpServletRequest request, boolean validateInput, int min,  int max){
        String levelName = request.getParameter("level-name");


        try{
            validator.validateStringLength(levelName, min, max);

        }catch(StringLengthFormatException e){
            request.setAttribute("name_validation_message", e.getMessage());
            validateInput = false;
        }
        return validateInput;
    }


    public boolean validateInputDescription(HttpServletRequest request, boolean validateInput, int min, int max){
        String levelName = request.getParameter("level-description");


        try{
            validator.validateStringLength(levelName, min, max);

        }catch(StringLengthFormatException e){
            request.setAttribute("description_validation_message", e.getMessage());
            validateInput = false;
        }
        return validateInput;
    }

    public boolean validateInputCoins(HttpServletRequest request, boolean isInputValid, int min, int max){
        try {
            validator.validateValue(request.getParameter("level-coins"), min, max);
        } catch (ValueFormatException e) {
            request.setAttribute("value_validation_message", e.getMessage());
            isInputValid = false;
        }
        return isInputValid;
    }

    private List<Level> sortList(List<Level> allArtifacts, boolean order, String sortBy) throws NoComparatorException {
        Comparing<Level> comparing = new ComparatorLevel();
        TypeColumn typeColumn = TypeColumn.returnType(sortBy);
        Comparator<Level> comparator = comparing.getComparator(typeColumn);
        SortItems<Level> sortItems = new SortItems<>(allArtifacts, comparator);

        return sortItems.sort(order);
    }
}
