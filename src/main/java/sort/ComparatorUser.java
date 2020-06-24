package sort;

import controller.users.TypeColumn;
import exception.NoComparatorException;
import model.CMSUser;

import java.util.Comparator;

public class ComparatorUser <T extends CMSUser> implements Comparing<T> {
        public Comparator<T> getComparator(TypeColumn typeColumn) throws NoComparatorException {
        Comparator<T> comparator = null;
        switch(typeColumn){
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
                throw new NoComparatorException("There is no comparator for a insert typeColumn.");
        }
        return comparator;
    }
}
