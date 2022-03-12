/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node temp =head;
        while(temp!= null) {
            Node copyNode = new Node(temp.val);
            
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }
        temp = head;
        
        while(temp != null) {
            temp.next.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }
        
        Node tempOldList = head;
        Node tempNewList = head.next;
        Node originalHead = head.next;
        while(tempOldList !=null) {
            tempOldList.next = tempOldList.next.next;
            tempNewList.next = (tempNewList.next != null) ? tempNewList.next.next : null;
            tempOldList = tempOldList.next;
            tempNewList = tempNewList.next;
        }
        return originalHead;
    }
}