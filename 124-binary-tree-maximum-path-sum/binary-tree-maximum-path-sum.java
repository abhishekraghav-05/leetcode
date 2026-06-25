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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        
        maxSum = Math.max(maxSum, node.val + left + right);
        
        return node.val + Math.max(left, right);
    }
}

// class Solution {
//     public int maxPathSum(TreeNode root) {
//         if(root == null) return 0;
        
//         int maxSum = 0;
            
//         maxPathSum(root.left);
//         maxPathSum(root.right);

//         int sum = root.left.val + root.val + root.right.val;
//         maxSum = Math.max(maxSum, sum);

//         return maxSum;
//     }
// }