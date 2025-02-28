
import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}

class LavelOrderTraversalLineByLine {
    Node root;

    void printLevelOrder1() {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node curr = q.poll();

            if(curr == null) {
                System.out.println();
                q.add(null);
                continue; }
           
            System.out.print(curr.val + " ");

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }
    }

    void printLevelOrder2() {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
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
        LavelOrderTraversalLineByLine tree = new LavelOrderTraversalLineByLine();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is Method 1 - ");
        tree.printLevelOrder1();
        System.out.println();
        System.out.println();
        System.out.println("Level order traversal of binary tree is Method 2 - ");
        tree.printLevelOrder2();
    }
}
