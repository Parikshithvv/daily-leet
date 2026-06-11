class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode gp = d;
        while (true) {
            ListNode kth = getK(gp, k);
            if (kth == null) break;
            ListNode gn = kth.next;
            ListNode prev = gn;
            ListNode curr = gp.next;
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = gp.next;
            gp.next = kth;
            gp = temp;
        }
        return d.next;
    }
    private ListNode getK(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}