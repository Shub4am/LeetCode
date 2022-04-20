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
class BSTIterator {
    Iterator<Integer> iterator;
    public BSTIterator(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        iterator = inorder.iterator();
    }
    private void inOrder(TreeNode node, List<Integer> inOrder) {
        if(node != null) {
            inOrder(node.left, inOrder);
            inOrder.add(node.val);
            inOrder(node.right, inOrder);
        }
    }
    public boolean hasNext() {
        return iterator.hasNext();
    }
    public int next() {
        return iterator.next();
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */