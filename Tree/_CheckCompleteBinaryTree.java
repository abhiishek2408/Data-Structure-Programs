/*To check whether a binary tree is a Complete Binary Tree (CBT), the condition is:

A Binary Tree is complete if all levels are completely filled except possibly the last, 
and all nodes are as far left as possible. eg. Heap is complete binary tree --- memory optimization, space optimization

Approach (Level Order Traversal - BFS):
Use a queue to perform level order traversal.
If we encounter a node that is null, all following nodes must also be null for it to be a CBT.
If we find a non-null node after a null node, then it is not a complete binary tree.
*/

package Tree;

import java.util.*;

class _CheckCompleteBinaryTree {

    static class Node {
        int data;
        Node left, right;
    
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Function जो बताएगा कि Binary Tree Complete है या नहीं
    boolean isCompleteBT(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                foundNull = true;  // null node मिला, अब आगे कोई भी node नहीं आना चाहिए
            } else {
                if (foundNull) {
                    // null के बाद कोई node आ गया — Complete Tree नहीं है
                    return false;
                }
                // बाएं और दाएं बच्चों को queue में डालना
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // सारे नियम सही रहे तो Tree complete है
        return true;
    }

    public static void main(String[] args) {
        /*
                  1
                 / \
                2   3
               / \
              4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        _CheckCompleteBinaryTree sol = new _CheckCompleteBinaryTree();
        boolean result = sol.isCompleteBT(root);

        System.out.println("क्या Tree Complete Binary Tree है? " + (result ? "हाँ ✅" : "नहीं ❌"));
    }
}
