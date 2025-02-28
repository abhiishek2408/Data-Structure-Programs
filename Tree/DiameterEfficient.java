
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class DiameterEfficient {
    Node root;
    int res = 0;

    int height(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        res = Math.max(res, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }

    int diameter() {
        height(root);
        return res;
    }

    public static void main(String[] args) {
        DiameterEfficient tree = new DiameterEfficient();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of the binary tree is: " + tree.diameter());
    }
}
