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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        // Ensure list for this level exists
        if (result.size() <= level) {
            result.add(new LinkedList<>());
        }

        // Insert depending on level parity
        if (level % 2 == 0) {
            result.get(level).add(node.val); // left to right
        } else {
            result.get(level).add(0, node.val); // right to left
        }

        // Recurse children
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}
