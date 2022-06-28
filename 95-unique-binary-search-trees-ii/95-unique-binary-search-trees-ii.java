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
    public List<TreeNode> generateTrees(int n) {
        return  generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> res = new ArrayList();
        if (low > high) {
            res.add(new TreeNode(-1));
            return res;
        } 
        for (int i = low; i <= high; i++){
            for (TreeNode left: generateTrees(low, i - 1)){
                for (TreeNode right: generateTrees(i + 1, high)){
                    if(left== null || left.val == -1){
                        left = null;
                    }
                    if(right==null || right.val == -1){
                        right = null;
                    }
                    TreeNode node = new TreeNode(i, left, right);
                    res.add(node);
                }
            }
        }
        return res;
    }
}