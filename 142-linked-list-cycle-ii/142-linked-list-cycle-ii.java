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
    public ListNode getIntersect(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow) {
                return slow;
            }
        }
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        
        ListNode intersect = getIntersect(head);
        if(intersect == null) return null;
    
        ListNode temp = head;
        ListNode curr = intersect;
        while(temp != curr) {
            temp = temp.next;
            curr = curr.next;
        }
        return temp;
    }  
}