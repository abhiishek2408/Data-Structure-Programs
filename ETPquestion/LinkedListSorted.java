package ETPquestion;

import java.util.Scanner;
//Q.8 Sort a LinkedList using Insertion Sort:
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedListSorted {
    public static Node insertAtEnd(Node head, int x) {
        Node current = new Node(x);
        if (head == null) return current;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = current;
        return head;
    }

    public static Node sortedInsert(Node head, Node newNode) {
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            return newNode;
        }
        Node current = head;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public static Node insertionSort(Node head) {
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        return sorted;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            head = insertAtEnd(head, x);
        }
        head = insertionSort(head);
        printList(head);
        sc.close();
    }
}
