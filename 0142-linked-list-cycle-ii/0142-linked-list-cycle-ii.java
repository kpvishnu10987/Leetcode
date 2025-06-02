/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            System.out.println("no cycle");
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int pos = 0;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                    pos++;
                }
                
                System.out.println("tail connects to node index "+pos);
                return slow;
            }
        }
        System.out.println("no cycle");
        return null;
        
    }
}