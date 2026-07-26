package Tree;

public class _07_MinimumNodeBinaryTree {

    static class Node {
        int val;
        Node left, right;
    
        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    // Method to find the minimum value in the binary tree
    int getMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.val, Math.min(getMin(root.left), getMin(root.right)));
    }

    public static void main(String[] args) {
        _07_MinimumNodeBinaryTree solution = new _07_MinimumNodeBinaryTree();
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.left = new Node(6);
        solution.root.right.right = new Node(7);

        System.out.println("Minimum value in the binary tree is " + solution.getMin(solution.root));
    }
}
