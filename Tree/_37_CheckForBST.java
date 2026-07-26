package Tree;

public class _37_CheckForBST {

    static class Node {
        int val; 
        Node left, right; 
    
        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }
    
    boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return isBSTUtil(node.left, min, node.val) && isBSTUtil(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        _37_CheckForBST solution = new _37_CheckForBST();

        if (solution.isBST(root)) {
            System.out.println("The tree is a Binary Search Tree.");
        } else {
            System.out.println("The tree is not a Binary Search Tree.");
        }
    }
}
