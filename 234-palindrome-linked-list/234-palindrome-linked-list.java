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
        ListNode slow = head, fast = head, mid = null;
        while(fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            mid = slow.next;
        }else {
            mid = slow;
        }
        
        ListNode prev = null, next = null;
        while(mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        
        while(prev != null) {
            if(prev.val != head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}