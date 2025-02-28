class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class DiameterOfBinaryTree {
    Node root;

    // Function to calculate height of the tree
    int height(Node root) {
        if (root == null) return 0;
        else
            return 1 + Math.max(height(root.left),height(root.right));
    }

    // Function to calculate diameter of the tree
    int diameter(Node root) {
        if (root == null) return 0;

        // Get the height of left and right subtrees
        int d1 = 1 + height(root.left) + height(root.right);

        // Get the diameter of left and right subtrees
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

  

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        
        // Creating a sample tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Height of tree: " +tree.height(tree.root));
        System.out.println("Diameter of tree (normal method): " + tree.diameter(tree.root));
      
    }
}