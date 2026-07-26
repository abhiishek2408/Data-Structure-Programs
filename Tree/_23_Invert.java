package Tree;

public class _23_Invert {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to invert a binary tree
    public Node invertTree(Node root) {
        if (root == null) return null;

        // Recursively swap left and right subtrees
        Node temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        _23_Invert solution = new _23_Invert();
        root = solution.invertTree(root);

        System.out.println("Inverted Tree (Preorder Traversal):");
        solution.printTree(root);
        System.out.println();
    }
}
