package LinkedList;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(Scanner sc, int n) {
        ListNode head = null, temp = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (head == null) {
                head = new ListNode(val);
                temp = head;
            } else {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        ListNode head1 = createList(sc, n1);
        int n2 = sc.nextInt();
        ListNode head2 = createList(sc, n2);
        ListNode mergedHead = mergeTwoLists(head1, head2);
        printList(mergedHead);
    }
}

