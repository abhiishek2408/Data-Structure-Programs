
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeToDLL {
    Node head = null; // Head of the DLL
    Node prev = null; // Previous node in the DLL

    Node BTToDLL(Node root) {
        if (root == null) return null;

        // Recursively convert the left subtree
        BTToDLL(root.left);

        // If this is the first node, set head
        if (prev == null) {
            head = root;
        } else {
            // Link the previous node with the current node
            root.left = prev;
            prev.right = root;
        }

        // Update prev to the current node
        prev = root;

        // Recursively convert the right subtree
        BTToDLL(root.right);

        return head;
    }

    // Function to print the doubly linked list
    void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        Node head = tree.BTToDLL(root);
        System.out.println("Doubly Linked List:");
        tree.printList(head);
    }
}