import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private QuickSort(){};

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    };

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;

        int p = partition(arr, l, r);
        partition(arr, l, p - 1);
        partition(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        // 生成 [l, r] 之间的随即索引
        int p = l + (new Random()).nextInt(r - l + 1); // 因为nextInt是开区间，所以+1，保持和[l, r]左闭右闭
        swap(arr, l, p);

        // arr[l+1...j] < v, arr[j+1...r] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort", arr);

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort", arr2);
    }
}
