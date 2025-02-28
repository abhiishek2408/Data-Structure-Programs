class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeToSinglyLinkedList {
    Node head = null; // Head of the linked list
    Node current = null; // Current node in the linked list

    void BTToSLL(Node root) {
        if (root == null) return;

        // Recursively convert the left subtree
        BTToSLL(root.left);

        // Create a new node for the current tree node
        Node newNode = new Node(root.data);

        // If this is the first node, set head
        if (head == null) {
            head = newNode;
            current = head; // Set current to head
        } else {
            current.right = newNode; // Link the previous node to the new node
            current = newNode; // Move current to the new node
        }

        // Recursively convert the right subtree
        BTToSLL(root.right);
    }

    // Function to print the linked list
    void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeToSinglyLinkedList tree = new BinaryTreeToSinglyLinkedList();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        tree.BTToSLL(root);
        System.out.println("Singly Linked List:");
        tree.printList(tree.head);
    }
}