public class BinarySearch {
    private BinarySearch(){};

    /**
     * 非递归实现二分查找法
     * @param data
     * @param target
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int  l = 0, r = data.length - 1;
        // 在 data[l, r] 的范围中查找target
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 递归是爱你二分查找法
     * @param data
     * @param target
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l < r) return -1;

        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0) {
            return mid;
        }

        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }

        return searchR(data, l, mid - 1, target);
    }

    /**
     * 2-2 实现 upper：大于 target 的最小值
     * @param data
     * @param target
     * @return index of 大于 target 的最小值
     * @param <E>
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        // 在 data[l, r] 中寻找解，注意 r 也是闭区间
        // r 的索引在取到 data.length 的时候，它不是数组data的一个合法索引
        // 但是它是我们在这个问题，在我们这个定义下的合法解
        int l = 0, r = data.length;

        // 循环定义不是 l <= r，因为在我们定义的搜索范围中
        // 一定有我们这个问题的解，所以当 l == r 碰上了，这一定是我们的解
        // 这和我们之前二分查找法寻找一个target的解法不同之处，因为可能找到/找不到（有解/没解）
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) { // 小细节 <=
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // 和return r一样的
    }

    /**
     * 1. 先找到比target大的最小值，退后一位，如果退后一位位置上的数字就是target，
     * 则返回索引即可（同时也满足”如果数组中存在元素，返回最大索引“）
     * 2. 如果退后一位位置上的数字不是target，则返回比target大的最小值索引（即上一节讨论过的upper）
     * @param data
     * @param target
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1] == target) {
            return u - 1;
        }
        return u;
    }


    public static void main(String[] args) {
//        Integer[] arr = {1, 1, 3, 3, 5, 5};
//        for (int i = 0; i <= 6; i++) {
//            System.out.print(BinarySearch.upper(arr, i) + " "); // 0 2 2 4 4 6 6
//        }
//        System.out.println();

        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.ceil(arr, i) + " "); // 0 1 2 3 4 5 6
        }
        System.out.println();
    }

}
