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
        StringBuffer sb = new StringBuffer();
        helperSer(root, sb);

        return sb.toString();
    }

    private void helperSer(TreeNode root, StringBuffer sb) {
        if(root == null) {
            sb.append("null,");
            return; 
        }
        sb.append(root.val).append(",");
        helperSer(root.left, sb);
        helperSer(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(
            Arrays.asList(data.split(","))
        );

        return helperDeser(q);
    }

    public TreeNode helperDeser(Queue<String> q) {
        String value = q.poll();
        if(value.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = helperDeser(q);
        node.right = helperDeser(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));