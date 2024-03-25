public class SelectionSort {
    private SelectionSort(){}

    // 接受泛型后，如果在method里想比较操作的话，还要extends Comparable
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i; j < arr.length; j++) {
                // 小于0的话：a < b; 等于0的话：a = b；大于0的话：a > b
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private static <E> void swap(E[] arr, int i, int minIdx) {
        // swap也要相应改成接受泛型
        E temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }

    public static void main(String[] args) {
        // 因为要接受泛型数组，这里要一个类Integer，而不能是一个基本数据类型int
        Integer[] arr = {1, 4, 6, 2, 7, 5, 3};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

}
