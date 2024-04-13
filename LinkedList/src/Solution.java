/**
 * 203 Remove LinkedList Element
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6, 1};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        Solution s1 = new Solution();
        ListNode res1 = s1.removeElements(head, 6);
        System.out.println(res1);

        ListNode res2 = (new Solution().removeElements(head, 1));
        System.out.println(res2);
    }
}
