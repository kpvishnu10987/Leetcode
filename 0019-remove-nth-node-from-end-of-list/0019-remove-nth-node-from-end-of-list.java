class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        // move fast n steps ahead
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        // if fast becomes null → remove head
        if(fast == null) return head.next;

        // move both until fast reaches end
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // delete node
        slow.next = slow.next.next;

        return head;
    }
}