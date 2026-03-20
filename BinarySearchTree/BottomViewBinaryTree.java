import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BottomViewBinaryTree {
    Node root;

    // Method to print the bottom view of the binary tree
    void bottomView(Node root) {
        if (root == null) return;

        // TreeMap to store the last node at each horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Queue to store nodes and their horizontal distance
        Queue<Pair> queue = new LinkedList<>();

        // Start with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node node = temp.node;
            int hd = temp.hd;

            // Update the map with the current node for this horizontal distance
            map.put(hd, node.data);

            // Enqueue left child with horizontal distance hd-1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Enqueue right child with horizontal distance hd+1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the bottom view
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
        BottomViewBinaryTree tree = new BottomViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Bottom view of the binary tree:");
        tree.bottomView(tree.root);
    }
}