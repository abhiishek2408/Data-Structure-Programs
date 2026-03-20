package Tree;

import java.util.*;
//BFT
class _LavelOrderTraversal {
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



    void printLevelOrder1() {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node curr = q.poll();

            if(curr == null) {
                System.out.println();
                q.add(null);
                continue; }
           
            System.out.print(curr.val + " ");

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String args[]) {
        _LavelOrderTraversal tree = new _LavelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree.printLevelOrder();
    }
}



/*Level Order Traversal (also known as Breadth-First Traversal) is a technique to 
  traverse a binary tree level by level, starting from the root. 
  
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

Level Order Output: 1 2 3 4 5 6 7
*/



/*We use a queue data structure to help us visit nodes level by level.
  
Algorithm Steps:
Create an empty queue.
Enqueue the root node.
While the queue is not empty:
Dequeue the front node.
Process the node (print/store its value).
Enqueue the left child (if exists).
Enqueue the right child (if exists).

Time Complexity: O(n) — Every node is visited once.
Space Complexity: O(n) — Due to the queue storing nodes level by level.
 */