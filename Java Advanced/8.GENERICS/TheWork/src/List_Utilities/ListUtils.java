package List_Utilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable> T getMax(List<T> theList) {
        if (theList.isEmpty()) {
            throw new  IllegalArgumentException();
        }
        return (T) Collections.max(theList);
    }
    public static <T extends Comparable> T getMin(List<T> theList) {
        if (theList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (T) Collections.min(theList);
    }
}
