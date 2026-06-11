/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fast = headA;
        ListNode slow = headB;
        
        if(headA == null && headB == null)return null;

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;

            if(fast == slow){
                return slow;
            }
            if(fast == null){
                fast = headB;

            }
            if(slow == null){
                slow = headA;
            }
        }
        return slow;
        
    }
}