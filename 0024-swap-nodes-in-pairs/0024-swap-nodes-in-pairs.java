/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            ListNode nextPair = fast.next.next;
            ListNode second = fast.next;
            second.next = fast;
            fast.next = nextPair;
            slow.next = second;
            slow = fast;
            fast = nextPair;
        }
        return dummy.next;
    }
}
