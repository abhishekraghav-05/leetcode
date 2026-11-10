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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int index = 0;
        if(n == 0) return null;
        if(n == 1) return new TreeNode(preorder[0]);

        for(int i = 0; i < postorder.length; i++) {
            if(postorder[i] == preorder[1]) {
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(preorder[0]);

        node.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, index + 2), 
        Arrays.copyOfRange(postorder, 0, index + 1));

        node.right = constructFromPrePost(Arrays.copyOfRange(preorder, index + 2, n), 
        Arrays.copyOfRange(postorder, index + 1, n));

        return node;
    }
}