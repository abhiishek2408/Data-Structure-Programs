package ETPquestion;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class LinkedListDuplicate {

    // Convert Linked List to List<Integer>
    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    // Return list of all duplicates using only ArrayList
    public static List<Integer> getAllDuplicates(ListNode head) {
        List<Integer> list = toList(head);
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (!duplicates.contains(current) && list.indexOf(current) != list.lastIndexOf(current)) {
                duplicates.add(current);
            }
        }
        
        return duplicates;
    }

    // Helper to create a sample linked list from array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0), curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Test driver
    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 2, 1});
        
        List<Integer> duplicates = getAllDuplicates(head);
        System.out.println("Duplicates: " + duplicates);  // Output: Duplicates: [1, 2]
    }
}
