package Tree;

public class _21_DiameterOfBinaryTree {
    Node root;

    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int diameter(Node root) {
        if (root == null) return 0;

        int d1 = height(root.left) + height(root.right) + 1;
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    // Efficient approach of finding diameter
    private int res = 0;

    private int heightEfficient(Node root) {
        if (root == null) return 0;

        int lh = heightEfficient(root.left);
        int rh = heightEfficient(root.right);

        res = Math.max(res, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public int diameterEfficient(Node root) {
        res = 0;
        heightEfficient(root);
        return res;
    }

    public static void main(String[] args) {
        _21_DiameterOfBinaryTree solution = new _21_DiameterOfBinaryTree();

        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        
        System.out.println("Height of tree: " + solution.height(solution.root));
        System.out.println("Diameter of tree (Naive): " + solution.diameter(solution.root));
        System.out.println("Diameter of tree (Efficient): " + solution.diameterEfficient(solution.root));
    }
}