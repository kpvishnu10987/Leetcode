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
    public void reorderList(ListNode head) {
        if(head == null) return ;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode sec = reverse(slow.next);
        slow.next = null;

        merge(head,sec);
    }
    private ListNode reverse(ListNode node){
        if(node == null) return node;

        ListNode cur = node;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode s,ListNode t){
        while(s != null && t != null){
            ListNode sn = s.next;
            ListNode tn = t.next;

            s.next = t;
            t.next = sn;

            s = sn;
            t = tn;
        }
    }
}