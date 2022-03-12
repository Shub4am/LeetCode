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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null)
            return head;
        
        ListNode curr = head;
        int length = 1;
        while(curr.next != null) {
            length++;
            curr = curr.next;
        }
        curr.next = head;
        k = k % length;
        for( int  i = 0; i < length - k; i++) 
            curr = curr.next;
        
        head = curr.next;
        curr.next = null;
        return head;
    }
}