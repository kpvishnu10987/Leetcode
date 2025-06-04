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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Stack<Integer> st= new Stack<>();
        ListNode temp = head;
        ListNode sorted = null;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        while(!st.isEmpty()){
            int key = st.pop();
            ListNode temp2 = new ListNode(key);
        
            if(sorted == null || temp2.val<=sorted.val){
                temp2.next = sorted;
                sorted = temp2;
            }else{
                temp = sorted;
                while(temp.next != null &&temp.next.val<temp2.val){
                    temp = temp.next;
                }
                temp2.next = temp.next;
                temp.next = temp2;
            }
        }
    return sorted;
    }
}