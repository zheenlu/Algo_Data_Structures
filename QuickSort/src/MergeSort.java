import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    /**
     * Up to bottom
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 优化2
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }
        if (l - r >= 15) {
            InsertionSort.sort4(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        // 优化1
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    /**
     * MergeSort from bottom to up
     * @param arr
     */
    public static <E extends Comparable<E>> void sortBU(E[]arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        // 遍历合并的区间长度1, 2, 4, 8...
        for (int size = 1; size < n; size += size) {
            // 遍历合并的两个区间起始位置 i
            // 合并 [i, i + size - 1] 和 [i + size, i + size + size - 1]
            // 看了下面的注释后，更准确的是 "合并 [i, i + size - 1] 和 [i + size, Math.min(i + size + size - 1, n - 1)]"
            for (int i = 0; i + size < n; i += size + size) {
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    // 用Math.min因为i + size + size - 1可能越界
                    // 比如arr总长度为10，size为8时，前面一个arr有8个元素，而后面一个arr只有2个元素
                    merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1), temp);
                }
            }
        }
    }

    /**
     * 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param temp
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        // 不用担心偏移了，因为拷贝arr到temp也是从i开始的
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 左边区间看完了
                arr[k] = temp[j];
                j++;
            } else if (j > r) { // 右边元素看完了
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortBU", arr);
    }
}
