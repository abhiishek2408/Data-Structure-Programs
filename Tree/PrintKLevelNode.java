package Tree;

class Node {
    Node root, left, right;
    int val;

    Node(int val) {
        this.val = val;
        root = null;
        right = null;
        left = null;
    }
}

public class PrintKLevelNode {
    public static void printkDist(Node root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.val + " ");
        } else {
            printkDist(root.right, k - 1);
            printkDist(root.left, k - 1);
        }
    }

    public static void main(String[] args) {
        // Example tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        System.out.print("Nodes at level " + k + ": ");
        printkDist(root, k); 
    }
}
