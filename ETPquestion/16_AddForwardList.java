package ETPquestion;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddForwardList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Push all nodes into stacks
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();

            carry = sum / 10;

            // Insert node at the front (head insertion)
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    // Helper to print list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // l1 = 2 -> 3 -> 1 (231)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(1);

        // l2 = 7 -> 4 -> 5 (745)
        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        AddForwardList solution = new AddForwardList();
        ListNode result = solution.addTwoNumbers(l1, l2);

        printList(result); // Output: 9 7 6
    }
}

