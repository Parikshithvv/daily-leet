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
    public ListNode rll(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = rll(slow.next);

        ListNode first = head;
        ListNode second = newhead;
        boolean result = true;

        
        while (second != null) {
            if (first.val != second.val) {
                result = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        return result;
    }
}