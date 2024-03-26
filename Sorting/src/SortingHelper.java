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

    public static <E extends Comparable<E>> void sortTest(String sortMethod, E[] arr) {
        double startTime = System.nanoTime();
        if (sortMethod.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        } else if (sortMethod.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        }
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortMethod + "failed");
        }
        System.out.println(String.format("%s, n = %d : %f s", sortMethod, arr.length, time));
    }
}
