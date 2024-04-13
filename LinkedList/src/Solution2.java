/**
 *  * 203.
 *  * https://leetcode.com/problems/remove-linked-list-elements/
 *  depth是帮助我们调试递归，每次+1
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val) { // head满足删除条件
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6, 1};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        Solution2 s1 = new Solution2();
        ListNode res1 = s1.removeElements(head, 6, 0);
        System.out.println(res1);

//        ListNode res2 = (new Solution2().removeElements(head, 1));
//        System.out.println(res2);
    }
}
