package Tree;

import java.util.*;

public class _11_LevelOrderTraversal {
    Node root;

    static class Node {
        int val;
        Node left, right;
    
        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    void printLevelOrder() {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();   // front element
            System.out.print(curr.val + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String args[]) {
        _11_LevelOrderTraversal solution = new _11_LevelOrderTraversal();
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        solution.printLevelOrder();
        System.out.println();
    }
}
