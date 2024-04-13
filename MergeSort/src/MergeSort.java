import java.util.Arrays;

public class MergeSort {
    private MergeSort(){};

    public static <E extends Comparable<E>> void sort(E[] arr) {}

    /**
     * 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param <E>
     */
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

}
