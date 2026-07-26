package ETPquestion;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListPalindrome {
    public static Node insertAtEnd(Node head, int x) {
        Node current = new Node(x);
        if (head == null) return current;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
        }
        temp.next = current;
        return head;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null, current = slow, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare both halves
        Node firstHalf = head, secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            head = insertAtEnd(head, x);
        }
        System.out.println(isPalindrome(head) ? 1 : 0);
        scanner.close();
    }
}
