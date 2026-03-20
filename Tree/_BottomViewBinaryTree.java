package Tree;

import java.util.*;

class _BottomViewBinaryTree{

    static class Node{

        int data;       // Data of the node
        int hd;         // Horizontal distance from root
        Node left, right; // Left and right child references
    
        public Node(int key){
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    // Function to return a list containing the bottom view of the given tree
    public ArrayList<Integer> bottomView(Node root){

        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        
        TreeMap<Integer, Integer> map = new TreeMap<>(); // TreeMap to store horizontal distance and the last node at that distance
        Queue<Node> queue = new LinkedList<>();        // Queue for BFS traversal

        
        root.hd = 0;       // Set the root's horizontal distance to 0 and enqueue it
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int hd = temp.hd;

            // Update the map (bottom-most node for each horizontal distance)
            map.put(hd, temp.data);

            // Add left child with hd - 1
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            // Add right child with hd + 1
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        // Add the bottom view nodes from left to right
        result.addAll(map.values());

        return result;
    }

    public class Main {
        public static void main(String[] args) {
            // Create a simple binary tree
            Node root = new Node(20);
            root.left = new Node(8);
            root.right = new Node(22);
            root.left.left = new Node(5);
            root.left.right = new Node(3);
            root.right.left = new Node(4);
            root.right.right = new Node(25);
            root.left.right.left = new Node(10);
            root.left.right.right = new Node(14);
    
            _BottomViewBinaryTree solution = new _BottomViewBinaryTree();
            ArrayList<Integer> bottomView = solution.bottomView(root);
            System.out.println("Bottom View: " + bottomView);
        }
    }
    
}
