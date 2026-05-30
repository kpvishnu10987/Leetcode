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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                ListNode nn = new ListNode(t1.val);
                cur.next = nn;
                cur = nn;
                t1 = t1.next;
            }else{
                ListNode nn = new ListNode(t2.val);
                cur.next = nn;
                cur = nn;
                t2 = t2.next;
            }
        }

        if(t1 != null || t2!=null){
            if(t1 != null){
                cur.next = t1;
            }else{
                cur.next = t2;
            }
        }
        if (dummy == null) return null;

        return dummy.next;
    }
}