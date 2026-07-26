package Tree;

import java.util.ArrayList;
import java.util.List;

public class _35_FindAllPathSumEqualToTarget {
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    
    private void findPaths(Node node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        currentPath.add(node.val);
        
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        _35_FindAllPathSumEqualToTarget solution = new _35_FindAllPathSumEqualToTarget();

        int targetSum = 22;
        List<List<Integer>> paths = solution.pathSum(root, targetSum);

        System.out.println("Paths that sum to " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
