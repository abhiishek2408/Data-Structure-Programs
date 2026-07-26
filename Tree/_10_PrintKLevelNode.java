package Tree;

public class _10_PrintKLevelNode {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public void printkDist(Node root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.val + " ");
        } else {
            printkDist(root.left, k - 1);
            printkDist(root.right, k - 1);
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

        _10_PrintKLevelNode solution = new _10_PrintKLevelNode();
        int k = 2;
        System.out.print("Nodes at level " + k + ": ");
        solution.printkDist(root, k); 
        System.out.println();
    }
}
