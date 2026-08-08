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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }else{
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            }

        }
        if(l1 != null) tail.next= l1;
        if(l2 != null) tail.next = l2;

        return head.next;
    }
}