package collections;

import java.util.List;
import java.util.Collections;

public class ListMerger {

    public static void mergeIntoFirst(List<Integer> list1, List<Integer> list2) {
        for (int element : list2) {
            int pos = Collections.binarySearch(list1, element);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            list1.add(pos, element);
        }
    }
}