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
    int total = 0;
    public int[] findAvg(TreeNode root) {
        if(root == null) return new int[] {0,0}; 
        int[] leftRes = findAvg(root.left);
        int[] rightRes = findAvg(root.right);
        int totalSum = leftRes[0] + rightRes[0] + root.val;
        int totalNums = leftRes[1] + rightRes[1] + 1;
        if ( (totalSum / totalNums) == root.val)
            total++;
        return new int[] {totalSum, totalNums};
    }
    public int averageOfSubtree(TreeNode root) {
        int[] ans = findAvg(root);
        return total;
        
    }
}