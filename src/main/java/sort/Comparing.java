package sort;

import controller.users.TypeColumn;
import exception.NoComparatorException;

public interface Comparing<T>{
    java.util.Comparator<T> getComparator(TypeColumn typeColumn) throws NoComparatorException;
}
