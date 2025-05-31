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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp.next!= null){
            temp = temp.next;
            count++;
        }
        int middle = 0;
        if(count % 2 != 0){
            middle = (count+1)/2;
        }else{
            middle = count/2;
        }
        ListNode temp2 = head;
        while(middle != 0){
            temp2 = temp2.next;
            middle--;
        }
        head = temp2;
        return head;
        
        
    }
}