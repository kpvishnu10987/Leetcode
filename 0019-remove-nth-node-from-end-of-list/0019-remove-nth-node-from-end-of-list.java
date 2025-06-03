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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int key = count - n - 1;

        if (key < 0) {
            return head.next;
        }

        temp = head;
        count = 0;
        while (count != key && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}
