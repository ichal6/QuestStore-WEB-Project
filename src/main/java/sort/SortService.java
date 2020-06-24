package sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortService<T> {
    private List<T> allItems;
    private Comparator<T> comparator;

    public SortService(List<T> allItems, Comparator<T> comparator){
        this.allItems = allItems;
        this.comparator = comparator;
    }

    public List sort(boolean isAscending){
        if(!isAscending){
            comparator = comparator.reversed();
        }
        return allItems.stream().sorted(comparator).collect(Collectors.toList());
    }
}
