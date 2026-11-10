/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();
        preorder(root, l);
        return l;
    }

    private void preorder(Node root, List<Integer> l) {
        if(root == null) return;

        l.add(root.val);
        for(Node c : root.children) {
            preorder(c, l);
        }

    }
}