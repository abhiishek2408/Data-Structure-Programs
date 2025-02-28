import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
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

public class VerticalTraversal {
    Node root;

    // Method to perform vertical traversal
    void verticalOrder(Node root) {
        if (root == null) return;

        // TreeMap to store nodes at each horizontal distance
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Queue to store nodes and their horizontal distance
        Queue<Pair> queue = new LinkedList<>();

        // Start with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node node = temp.node;
            int hd = temp.hd;

            // Add the node's data to the map at the corresponding horizontal distance checks 
            // if the map contains the key hd. If not, it initializes a new ArrayList for that key. Then,
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(node.data);


            // Enqueue left child with horizontal distance hd-1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Enqueue right child with horizontal distance hd+1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the vertical order traversal
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for (int value : entry.getValue()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        VerticalTraversal tree = new VerticalTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Vertical order traversal of the binary tree:");
        tree.verticalOrder(tree.root);
    }
}