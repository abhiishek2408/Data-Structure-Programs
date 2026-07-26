package Tree;

public class _32_BinaryTreeToDoublyLinkedList {

    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Node head = null; // Head of the DLL
    Node prev = null; // Previous node in the DLL

    Node BTToDLL(Node root) {
        if (root == null) return null;

        BTToDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        BTToDLL(root.right);

        return head;
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
        _32_BinaryTreeToDoublyLinkedList solution = new _32_BinaryTreeToDoublyLinkedList();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        Node head = solution.BTToDLL(root);
        System.out.println("Doubly Linked List:");
        solution.printList(head);
    }
}