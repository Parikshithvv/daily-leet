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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        int maxVal= 0;
        while(secondHalf != null){
         maxVal = Math.max(maxVal, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxVal;
    }




        private ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null){
                ListNode nextnode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextnode;

            }
            return prev;
        }
    



        
    }
