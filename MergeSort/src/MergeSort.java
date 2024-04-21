import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化1
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        // 优化2
        if (l - r >= 15) {
            InsertionSort.sort4(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        // 优化1
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1); // 左闭右开所以 r + 1

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 左边区间看完了
                // arr[k] 这时候应该等于arr[j]里取的值
                // 但不能直接写arr[j]，因为可能以及被覆盖了
                // arr[i] 是temp[0], arr[i+1] 是temp[1]
                // 因为有偏移，如果要想得到j位置的值，所以写成j-l
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) { // 右边元素看完了
                arr[k] = temp[i- l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] orderedArr = ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSort2", arr);

//        SortingHelper.sortTest("MergeSort", orderedArr);
//        SortingHelper.sortTest("MergeSort2", orderedArr);
    }
}
