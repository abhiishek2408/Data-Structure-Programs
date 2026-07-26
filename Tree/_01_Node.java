package Tree;

public class _01_Node {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private int maxLevel = 0;

    void printLeft(Node root, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            System.out.print(root.val + " ");
            maxLevel = level;
        }

        printLeft(root.left, level + 1);
        printLeft(root.right, level + 1);
    }

    void printLeftView(Node root) {
        maxLevel = 0;
        printLeft(root, 1);
    }

    void printRight(Node root, int level) {
        if (root == null) return;

        if (maxLevel < level) {
            System.out.print(root.val + " ");
            maxLevel = level;
        }

        printRight(root.right, level + 1);  // Traverse right first
        printRight(root.left, level + 1);
    }

    void printRightView(Node root) {
        maxLevel = 0;
        printRight(root, 1);
    }

    public static void main(String[] args) {
        _01_Node solution = new _01_Node();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Left view of the binary tree is:");
        solution.printLeftView(root);
        System.out.println();
    }
}