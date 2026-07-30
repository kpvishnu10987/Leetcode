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
        ListNode dummy = new ListNode(0);;
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode rev = reverse(second);
        merge(dummy.next,rev);
        dummy.next = null;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next= prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode l1,ListNode l2){
        while(l1 != null && l2 != null){
            ListNode t1 = l1.next;
            l1.next = l2;
            l1 = t1;
            ListNode t2 = l2.next;
            l2.next = l1;
            l2 = t2;
        }
    }
}