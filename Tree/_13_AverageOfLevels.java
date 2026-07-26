package Tree;

import java.util.*;

public class _13_AverageOfLevels {

    static class Node {
        int val;
        Node left;
        Node right;
    
        Node(int val) { 
            this.val = val; 
        }
    }

    public List<Double> averageOfLevels(Node root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                sum += current.val;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(sum / levelSize);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        _13_AverageOfLevels solution = new _13_AverageOfLevels();
        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result); // Expected: [3.0, 14.5, 11.0]
    }
}
