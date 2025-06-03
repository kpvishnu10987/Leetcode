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
    public boolean isPalindrome(ListNode head) {
        if(head == null ||head.next == null){
            return true;
        }
        ListNode temp = head;
        ListNode temp2 = head;
        int vari = 0;
        Stack<Integer> st = new Stack<>();
        int count = 0;
        while(temp.next != null){
            
            count++;
            st.push(temp.val);
            temp =  temp.next;
        }
        st.push(temp.val);
        count++;
         int  mid = count/2;
        
        while(!st.isEmpty() && count != mid){
            vari = st.pop();
            if(temp2.val != vari){
                return false;
            }
            temp2 = temp2.next;
            count--;
        }
        return true;
    
        
    }
}