public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
//        ListNode res = removeElements(head.next, val);
//        if (head.val == val) { // head满足删除条件
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next, val); // 简略写法
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6, 1};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        Solution2 s1 = new Solution2();
        ListNode res1 = s1.removeElements(head, 6);
        System.out.println(res1);

        ListNode res2 = (new Solution2().removeElements(head, 1));
        System.out.println(res2);
    }
}
