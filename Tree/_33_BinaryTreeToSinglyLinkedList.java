package Tree;

public class _33_BinaryTreeToSinglyLinkedList {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Node head = null;
    Node current = null;

    void BTToSLL(Node root) {
        if (root == null) return;

        BTToSLL(root.left);

        Node newNode = new Node(root.val);

        if (head == null) {
            head = newNode;
            current = head;
        } else {
            current.right = newNode;
            current = newNode;
        }

        BTToSLL(root.right);
    }

    void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _33_BinaryTreeToSinglyLinkedList solution = new _33_BinaryTreeToSinglyLinkedList();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        solution.BTToSLL(root);
        System.out.println("Singly Linked List:");
        solution.printList(solution.head);
    }
}