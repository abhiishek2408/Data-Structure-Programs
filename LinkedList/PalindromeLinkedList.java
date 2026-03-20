package LinkedList;


class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
    
            // Step 1: Find the middle of the linked list
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
    
            // Step 2: Reverse the second half of the list
            ListNode secondHalfStart = reverseList(slow);
    
            // Step 3: Compare the first and second half
            ListNode firstHalfStart = head;
            ListNode secondHalfCopy = secondHalfStart; // To restore the list later
            while (secondHalfStart != null) {
                if (firstHalfStart.val != secondHalfStart.val) {
                    return false;
                }
                firstHalfStart = firstHalfStart.next;
                secondHalfStart = secondHalfStart.next;
            }
    
            // Step 4: Restore the list (optional)
            reverseList(secondHalfCopy);
    
            return true;
        }
    
        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
        }
    
        public static void main(String[] args) {
            // Create a sample linked list: 1 -> 2 -> 2 -> 1
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);
    
            PalindromeLinkedList solution = new PalindromeLinkedList();
            boolean result = solution.isPalindrome(head);
    
            System.out.println("Is the linked list a palindrome? " + result);
        }
    }

