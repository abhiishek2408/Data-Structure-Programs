import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    int maxWidth(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int count = q.size();
            maxWidth = Math.max(maxWidth, count);

            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        
        System.out.println("Maximum width of the tree is: " + tree.maxWidth(tree.root));
    }
}
