// 2.31-6 换个定义实现二分查找法

public class Solution {
    public int search(int[] data, int target) {
        // 在 [l, r) 中寻找 target
        // r取开区间，要覆盖所有data值，所以初始值是data.length而不是闭区间时 [l, r] 的data.length - 1
        int l = 0, r = data.length;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid] == target) {
                return mid;
            }
            if (data[mid] < target) {
                l = mid + 1; // 继续在 data[mid + 1, r) 中寻找 target
            }
            else {
                r = mid; // 继续在 data[l, mid) 中寻找target
            }
        }

        return -1;
    }

}
