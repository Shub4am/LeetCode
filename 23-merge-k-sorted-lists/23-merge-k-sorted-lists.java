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
        if(lists.length == 0) return null;
        int interval = 1;
        
        int len = lists.length;
        while(interval < len) {
            for(int i = 0; i < len - interval; i+=interval*2) {
                merge(lists, i, i+interval);
            }
            interval*=2;
        }
        return lists[0];
    }
    
    public void merge(ListNode[] lists, int index1, int index2) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        ListNode l1 = lists[index1];
        ListNode l2 = lists[index2];
        
        while(l1!= null || l2!= null) {
            if(l1 == null) {
                curr.next = l2;
                break;
            }
            if(l2 == null) {
                curr.next = l1;
                break;
            }
            if(l1.val  < l2.val) {
                curr.next = l1;
                l1= l1.next;
            }else {
                curr.next = l2;
                l2= l2.next;
            }
            curr = curr.next;
        }
        lists[index1] = res.next;
    }
}