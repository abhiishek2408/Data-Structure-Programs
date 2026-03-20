
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BTSpiralFormByLevelOrder {
    void printSpiral(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();     //******** */
        boolean reverse = false;                     //******** */

        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();

                if (reverse) {          //******** */
                    s.push(curr.key);   //******** */
                } 
                
                else {
                    System.out.print(curr.key + " ");
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (reverse) {                       //******** */
                while (!s.isEmpty()) {           //******** */
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse; // Toggle the reverse flag
        }
    }

    public static void main(String[] args) {
        BTSpiralFormByLevelOrder tree = new BTSpiralFormByLevelOrder();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Spiral Order traversal of the binary tree:");
        tree.printSpiral(root);
    }
}