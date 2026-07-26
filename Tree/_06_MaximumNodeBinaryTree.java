package Tree;

public class _06_MaximumNodeBinaryTree {

    static class Node {
        int val;
        Node left, right;
    
        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }
    
    Node root;

    // Method to find the maximum value in the binary tree
    int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.val, Math.max(getMax(root.left), getMax(root.right)));
        }
    }

    public static void main(String[] args) {
        _06_MaximumNodeBinaryTree solution = new _06_MaximumNodeBinaryTree();
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.left = new Node(6);
        solution.root.right.right = new Node(7);
    
        System.out.println("Maximum value in the binary tree is " + solution.getMax(solution.root));
    }
}
