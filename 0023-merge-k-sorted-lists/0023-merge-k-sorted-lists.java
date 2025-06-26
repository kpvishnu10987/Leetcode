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
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(ListNode head : lists){
            ListNode curr = head;
            while(curr != null){
                minheap.add(curr.val);
                curr = curr.next;
            }
        }
        ListNode ans = new ListNode(-1);
        ListNode tail = ans;
        while(!minheap.isEmpty()){
            int ele = minheap.poll();
            tail.next = new ListNode(ele);
            tail = tail.next;
        }
        return ans.next;
        
    }
}