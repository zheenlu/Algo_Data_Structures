/**
 * 2-3 递归基础与递归的宏观语意
 */
public class Sum {
    /**
     * 用户运行这个就好了，不需要知道我们下面写的private method
     * @param arr
     * @return
     */
    public static int Sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n)这个区间内所有数字的和
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Sum(nums));
    }
}
