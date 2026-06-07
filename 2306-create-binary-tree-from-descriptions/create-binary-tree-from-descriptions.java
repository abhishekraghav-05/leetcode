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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();

        Set<Integer> children = new HashSet<>();

        for(int[] node : descriptions) {
            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];

            map.putIfAbsent(parent, new TreeNode(parent));

            map.putIfAbsent(child, new TreeNode(child));

            if(isLeft == 1) {
                map.get(parent).left = map.get(child);
            }else{
                map.get(parent).right = map.get(child);
            }

            children.add(child);
        }    

        TreeNode root = null;
        for(int value : map.keySet()) {
            if(!children.contains(value)) {
                root = map.get(value);
            }
        }

        return root;
    }
    
}