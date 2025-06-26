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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists){
            if(head != null){
                minheap.offer(head);
            }     
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!minheap.isEmpty()){
            ListNode node = minheap.poll();
            tail.next = node;
            tail=tail.next;
            while(node.next != null){
                minheap.offer(node.next);
            }
        }
        return dummy.next;
        
    }
}