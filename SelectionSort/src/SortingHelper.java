public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
