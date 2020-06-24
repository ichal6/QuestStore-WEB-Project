package service;

import controller.users.TypeColumn;
import model.CMSUser;

import javax.servlet.ServletException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//If we would like use this function in our all lists,
// we should create abstract model class from which extends all models
// and replace CMSUser that abstract class
public class SortService<T extends CMSUser> {
    private List<T> allItems;
    public SortService(List<T> allItems){
        this.allItems = allItems;
    }

    public List<T> sort(TypeColumn typeOfColumn, boolean isAscending) {
        Comparator<T> comparator = null;
        switch(typeOfColumn){
            case NAME:
                comparator = Comparator.comparing(T::getName);
                break;
            case EMAIL:
                comparator = Comparator.comparing(T::getEmail);
                break;
            case CITY:
                comparator = Comparator.comparing(T::getCity);
                break;
            case DATE:
                comparator = Comparator.comparing(T::getDateOfAdding);
                break;
            default:
                return allItems;
        }
        if(!isAscending){
            comparator = comparator.reversed();
        }
        return allItems.stream().sorted(comparator).collect(Collectors.toList());
    }

}
