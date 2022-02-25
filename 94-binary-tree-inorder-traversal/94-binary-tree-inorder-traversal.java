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
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> arrayList = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curr = root;

    while(curr!=null || !stack.empty()){
        while(curr!=null){
            stack.add(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        arrayList.add(curr.val);
        curr = curr.right;
    }

    return arrayList;
    }
}
