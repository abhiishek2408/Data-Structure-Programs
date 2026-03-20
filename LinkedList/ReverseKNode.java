package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseKNode {
    static Node reverse(Node head, int k) {
        if (head == null || k == 1) return head;
        Node current = head, prev = null, next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }
        
        return prev;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node insertAtEnd(Node head, int x) {
        Node current = new Node(x);
        if (head == null) return current;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = current;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt(), k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            head = insertAtEnd(head, x);
        }
        head = reverse(head, k);
        print(head);
    }
}

