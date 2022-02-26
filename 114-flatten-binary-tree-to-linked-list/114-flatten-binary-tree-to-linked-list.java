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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        TreeNode node = root;
        
        while(node!= null) {
            
            if(node.left != null){
                
                TreeNode rightmost = node.left;
                
                while(rightmost.right != null) 
                    rightmost = rightmost.right;
                
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            node = node.right;
        }
    }
}