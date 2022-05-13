/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node mostLeft = root;
        while (mostLeft != null) {
            Node c = mostLeft;
            mostLeft = null;
            Node preRight = null;
            while(c != null) {
                if (c.left != null && c.right != null) {
                    if (preRight != null) {
                        preRight.next = c.left;
                    }
                    c.left.next = c.right;
                    preRight = c.right;
                } else if (c.left != null) {
                    if (preRight != null) {
                        preRight.next = c.left;
                    }
                    preRight = c.left;
                } else if (c.right != null) {
                    if (preRight != null) {
                        preRight.next = c.right;
                    }
                    preRight = c.right;
                }
                if (mostLeft == null) {
                    mostLeft = c.left == null ? c.right: c.left;
                }
                c = c.next;
            }
        }
        return root;
    }
}