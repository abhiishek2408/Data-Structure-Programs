package Tree;

import java.util.*;

// Node class definition


// Solution class with the topView logic
class _TopViewBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Helper class to pair node with horizontal distance
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return a list of nodes visible from the top view
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // Only record the first node for each horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }


// Main class

    public static void main(String[] args) {
        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> topViewResult = _TopViewBinaryTree.topView(root);
        System.out.println("Top View of Binary Tree: " + topViewResult);
    }
}
