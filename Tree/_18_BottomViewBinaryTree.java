package Tree;

import java.util.*;

public class _18_BottomViewBinaryTree {

    static class Node {
        int val;
        int hd; // Horizontal distance
        Node left, right;
    
        public Node(int val) {
            this.val = val;
            this.hd = 0;
            left = right = null;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int hd = temp.hd;

            map.put(hd, temp.val);

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        _18_BottomViewBinaryTree solution = new _18_BottomViewBinaryTree();
        ArrayList<Integer> bottomView = solution.bottomView(root);
        System.out.println("Bottom View: " + bottomView);
    }
}
