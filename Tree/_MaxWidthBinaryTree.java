/*To compute the maximum width of a binary tree, one must consider not merely the 
number of nodes at each level, but the width as defined by the position indices of 
the nodes if the tree were a complete binary tree. The width is calculated as:

width = (rightmost index at that level) - (leftmost index at that level) + 1 


1--Perform a level-order traversal (BFS) using a queue.

2--For each node, maintain its position index based on a complete binary tree structure:
   If a node has index i, then:
   Left child gets index 2 * i
   Right child gets index 2 * i + 1

3--For every level:
   Record the first and last indices
   Compute width using their difference
   Update the global maximum width

*/
package Tree;

import java.util.*;

public class _MaxWidthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // Custom Pair class to hold (TreeNode, index)
    static class Pair {
        TreeNode node;
        int index;
    
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Function to calculate the maximum width
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index - minIndex; // normalize index

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * index));
                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * index + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    // Driver code for testing
    public static void main(String[] args) {
        /*
                 1
               /   \
              3     2
             / \     \
            5   3     9
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        _MaxWidthBinaryTree solver = new _MaxWidthBinaryTree();
        int result = solver.widthOfBinaryTree(root);
        System.out.println("Maximum Width of Binary Tree: " + result);
    }
}

