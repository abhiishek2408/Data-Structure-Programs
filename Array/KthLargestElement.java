package Array;

// KthLargestElement.java
// Finds the Kth largest element in an array
/*
Test case:
Input: arr = {3,2,1,5,6,4}, k = 2
Output: 5
Input: arr = {3,2,3,1,2,4,5,5,6}, k = 4
Output: 4
*/

import java.util.PriorityQueue;

class KthLargestElement {
    // Returns the Kth largest element in the array
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,1,5,6,4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr1, 2)); // 5
        System.out.println(findKthLargest(arr2, 4)); // 4
    }
}
