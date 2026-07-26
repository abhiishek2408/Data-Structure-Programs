package ETPquestion;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class LinkedListProblems {

    // Convert Linked List to List<Integer>
    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    // 1. Palindrome check
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = toList(head);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) return false;
            i++; j--;
        }
        return true;
    }

    // 2. Find middle node value
    public static int findMiddle(ListNode head) {
        List<Integer> list = toList(head);
        return list.get(list.size() / 2);
    }

    // 3. Detect duplicates
    public static boolean hasDuplicate(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head.val)) return true;
            head = head.next;
        }
        return false;
    }

    // 4. Two sum check
    public static boolean twoSum(ListNode head, int target) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(target - head.val)) return true;
            set.add(head.val);
            head = head.next;
        }
        return false;
    }

    // 5. Reverse values
    public static int[] reverseValues(ListNode head) {
        List<Integer> list = toList(head);
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    // 6. Convert to number (as integer)
    public static int toNumber(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString());
    }

    // 7. Symmetry check
    public static boolean isSymmetric(ListNode head) {
        List<Integer> list = toList(head);
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            if (!list.get(i).equals(list.get(n - 1 - i))) return false;
        }
        return true;
    }

    // 7b. Check if one list is a rotation of another
    public static boolean isRotated(ListNode l1, ListNode l2) {
        List<Integer> a = toList(l1);
        List<Integer> b = toList(l2);
        if (a.size() != b.size()) return false;
        List<Integer> doubled = new ArrayList<>(a);
        doubled.addAll(a);
        return Collections.indexOfSubList(doubled, b) != -1;
    }

    // 8. Kth node from end
    public static int kthFromEnd(ListNode head, int k) {
        List<Integer> list = toList(head);
        if (k > list.size()) throw new IllegalArgumentException("k is too large");
        return list.get(list.size() - k);
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
        ListNode head2 = buildList(new int[]{3, 2, 1, 1, 2});

        System.out.println("Is Palindrome? " + isPalindrome(head));                  // true
        System.out.println("Middle Node: " + findMiddle(head));                      // 3
        System.out.println("Has Duplicates? " + hasDuplicate(head));                 // true
        System.out.println("Two Sum 4? " + twoSum(head, 4));                         // true (1+3)
        System.out.println("Reversed Values: " + Arrays.toString(reverseValues(head))); // [1, 2, 3, 2, 1]
        System.out.println("To Number: " + toNumber(head));                          // 12321
        System.out.println("Is Symmetric? " + isSymmetric(head));                    // true
        System.out.println("Is Rotation? " + isRotated(head, head2));                // true
        System.out.println("2nd from End: " + kthFromEnd(head, 2));                  // 2
    }
}
