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
    int max_Path_Sum;
    
    public int maxPathSum(TreeNode root) {
        max_Path_Sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_Path_Sum;
    }
    
    public int pathSum(TreeNode root) {
        if( root == null) return 0;
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        max_Path_Sum = Math.max(max_Path_Sum, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}