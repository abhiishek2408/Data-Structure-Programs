import java.util.*;

class LeftViewByIteration {

    class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    Node root; // Root node of the tree

    void printLevelOrder2() {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (i == 0)
                    System.out.print(curr.val + " ");

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }

            System.out.println();
        }
    }

    public static void main(String args[]) {
        LeftViewByIteration tree = new LeftViewByIteration();

        // Creating nodes using the outer class method
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);

        System.out.println("Level order traversal of binary tree is Method 2 - ");
        tree.printLevelOrder2();
    }
}
