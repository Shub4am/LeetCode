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
    HashMap<Integer, Integer> hashmap = new HashMap<>();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
            hashmap.put(inorder[i], i);
        return constructBinaryTree(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode constructBinaryTree(int [] preorder, int[] inorder, int start, int end) {
        if(start > end)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        if(root == null)
            return null;
        if(start == end)
            return root;
        int index = hashmap.get(root.val);
        
        root.left = constructBinaryTree(preorder, inorder, start, index - 1);
        root.right = constructBinaryTree(preorder, inorder, index + 1, end);
        
        return root;
    }
}