package Tree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Invert {

    // Function to invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Recursively swap left and right subtrees
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Inverting the tree
        Invert obj = new Invert();
        root = obj.invertTree(root);

        // Printing the inverted tree
        System.out.println("Inverted Tree (Preorder Traversal):");
        obj.printTree(root);
    }

    // Helper function to print the tree in Preorder Traversal
    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
