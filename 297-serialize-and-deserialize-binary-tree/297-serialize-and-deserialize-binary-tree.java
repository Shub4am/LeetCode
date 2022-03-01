/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeString(root, sb);
        return sb.toString();
    }
    
    private void serializeString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        serializeString(node.left, sb);
        serializeString(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList(Arrays.asList(data.split(",")));
        return buildTree(linkedList);
    }
    private TreeNode buildTree(LinkedList<String> stringList) {
        String index = stringList.removeFirst();
        if(index.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(index));
        node.left = buildTree(stringList);
        node.right = buildTree(stringList);
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));