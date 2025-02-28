import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TopViewBinaryTree {
    Node root;

    // Method to print the top view of the binary tree
    void topView(Node root) {
        if (root == null) return;

        // TreeMap to store the first node at each horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Queue to store nodes and their horizontal distance
        Queue<Pair> queue = new LinkedList<>();

        // Start with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node node = temp.node;
            int hd = temp.hd;

            // If the horizontal distance is not already in the map, add it
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Enqueue left child with horizontal distance hd-1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Enqueue right child with horizontal distance hd+1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the top view
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Helper class to store a node and its horizontal distance
    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {
        TopViewBinaryTree tree = new TopViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Top view of the binary tree:");
        tree.topView(tree.root);
    }
}