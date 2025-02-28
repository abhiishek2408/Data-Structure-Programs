
public class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class LeftViewByRecursion {
    Node root;
    int maxLevel = 0;

    void printLeft(Node root, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }

        printLeft(root.left, level + 1);
        printLeft(root.right, level + 1);
    }

    void printLeftView(Node root) {
        printLeft(root, 1);
    }

    public static void main(String[] args) {
        LeftViewByRecursion tree = new LeftViewByRecursion();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Left view of the binary tree is:");
        tree.printLeftView(tree.root);
    }
}