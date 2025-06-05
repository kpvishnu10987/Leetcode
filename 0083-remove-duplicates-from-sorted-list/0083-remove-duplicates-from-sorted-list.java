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
    public ListNode deleteDuplicates(ListNode head) {
    ListNode temp = head;
    ListNode prev = null;
    while(temp != null){
        prev = temp;
        while(temp.next !=null&& temp.next.val == prev.val){
            temp = temp.next;
        }
        prev.next = temp.next;
        temp = prev.next;
    }
    return head;
        
    }
}