import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class ListMerger {

    private final List<Integer> list1;
    private final List<Integer> list2;

    public ListMerger(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public void mergeIntoFirst() {
        for (int element : list2) {
            int pos = Collections.binarySearch(list1, element);
            if (pos < 0) pos = -(pos + 1);
            list1.add(pos, element);
        }
    }

    @Override
    public String toString() {
        return "Результат слияния: " + list1;
    }
}