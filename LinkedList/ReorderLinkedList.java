package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class ReorderLinkedList {
    static Node insertAtEnd(Node head, int x) {
        Node current = new Node(x);
        if (head == null) return current;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = current;
        return head;
    }

    static void reorderList(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        slow.next = null;
        second = reverseList(second);

        Node first = head;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    static Node reverseList(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            head = insertAtEnd(head, x);
        }
        reorderList(head);
        printList(head);
    }
}
