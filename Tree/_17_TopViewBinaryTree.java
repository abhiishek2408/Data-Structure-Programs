package Tree;

import java.util.*;

public class _17_TopViewBinaryTree {

    static class Node {
        int val;
        Node left;
        Node right;
    
        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        _17_TopViewBinaryTree solution = new _17_TopViewBinaryTree();
        ArrayList<Integer> topViewResult = solution.topView(root);
        System.out.println("Top View of Binary Tree: " + topViewResult);
    }
}
