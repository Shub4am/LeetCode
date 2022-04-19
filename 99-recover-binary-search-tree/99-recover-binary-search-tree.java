/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                parent = curr.left;
                while (parent.right != null && parent.right != curr) {
                    parent = parent.right;
                }
                if (parent.right == null) {
                    parent.right = curr;
                    curr = curr.left;
                    continue;
                } else {
                    parent.right = null;
                }
            }
            if (prev != null) {
                if (prev.val > curr.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = curr;
                }
            }
            prev = curr;
            curr = curr.right;
        }
        final int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}