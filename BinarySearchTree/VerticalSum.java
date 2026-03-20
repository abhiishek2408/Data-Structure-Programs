
import java.util.Map;
import java.util.TreeMap;

// Node class to represent each node in the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class VerticalSum {
    Node root;

    // Recursive function to calculate vertical sum
    void vSumR(Node root, int hd, TreeMap<Integer, Integer> mp) {
        // Base case: if the node is null, return
        if (root == null) return;

        // Recur for the left subtree with horizontal distance hd-1
        vSumR(root.left, hd - 1, mp);

        // Get the current sum for the horizontal distance
        int pSum = (mp.get(hd) == null) ? 0 : mp.get(hd);

        // Update the map with the new sum for this horizontal distance
        mp.put(hd, pSum + root.data);

        // Recur for the right subtree with horizontal distance hd+1
        vSumR(root.right, hd + 1, mp);
    }

    // Function to calculate and print vertical sums
    void vSum(Node root) {
        // Create a TreeMap to store sums of nodes at each horizontal distance
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        // Call the recursive function to fill the map
        vSumR(root, 0, mp);

        // Iterate over the map and print the vertical sums
        for (Map.Entry<Integer, Integer> sum : mp.entrySet()) {
            System.out.print(sum.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        VerticalSum tree = new VerticalSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Vertical sums of the binary tree:");
        tree.vSum(tree.root);
    }
}
