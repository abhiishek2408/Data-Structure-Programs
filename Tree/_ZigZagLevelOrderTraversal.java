package Tree;

import java.util.*;

public class _ZigZagLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> levelNodes = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (leftToRight) {
                    levelNodes.addLast(currentNode.val);
                } else {
                    levelNodes.addFirst(currentNode.val);
                }

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            result.add(new ArrayList<>(levelNodes));
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        _ZigZagLevelOrderTraversal tree = new _ZigZagLevelOrderTraversal();

        // Constructing the binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> zigzagOrder = tree.zigzagLevelOrder(root);
        System.out.println("Zigzag Level Order Traversal:");

        for (List<Integer> level : zigzagOrder) {
            System.out.println(level);
        }
    }
}

