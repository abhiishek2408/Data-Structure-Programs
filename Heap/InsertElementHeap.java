package Heap;

import java.util.*;

class InsertElementHeap {
    static int n = 7;

    // Function to heapify ith node in a Heap of size n
    // following a Bottom-up approach
    static void heapify(List<Integer> arr, int n, int i) {
        int parent = (i - 1) / 2;
        
        // For Max-Heap
        // If current node is greater than its parent
        // Swap both of them and call heapify again for the parent
        if (parent >= 0 && arr.get(i) > arr.get(parent)) {
            Collections.swap(arr, i, parent);
            // Recursively heapify the parent node
            heapify(arr, n, parent);
        }
    }

    // Function to insert a new node to the Heap
    static void insertNode(List<Integer> arr, int key) {
        // Increase the size of Heap by 1
        n++;
        // Insert the element at the end of Heap
        arr.add(key);
        // Heapify the new node following a Bottom-up approach
        heapify(arr, n, n - 1);
    }

    // A utility function to print array of size n
    static void printArr(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
     
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 5, 3, 2, 4, 1, 7));
        int key = 15;
        insertNode(arr, key);
        printArr(arr);
    }
}
