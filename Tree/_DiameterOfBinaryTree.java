package Tree;

public class _DiameterOfBinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    
    int height(Node root) {
        if (root == null) return 0;
        else
            return 1 + Math.max(height(root.left),height(root.right));
    }

    int diameter(Node root) {
        if (root == null) return 0;

        int d1 = diameter(root.left);
        int d2 = diameter(root.right);
        int d3 = 1 + d1 + d2;

        return Math.max(d3, Math.max(d1, d2));
    }


// Efficient approach of finding diameter
    int res = 0;

    int heightEfficient(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        res = Math.max(res, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }

    int DiameterEfficient() {
        height(root);
        return res;
    }

  

    public static void main(String[] args) {
        _DiameterOfBinaryTree tree = new _DiameterOfBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Height of tree: " +tree.height(tree.root));
        System.out.println("Diameter of tree (normal method): " + tree.diameter(tree.root));
      
    }
}