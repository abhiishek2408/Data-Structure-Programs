package Recursion;

import java.util.*;

class PowerSetArray {
    

    // Power set method
    static void powerSet(int[] arr, int index, List<Integer> curr, List<List<Integer>> list) {
        int n = arr.length;

        // Base case
        if (index == n) {
            list.add(new ArrayList<>(curr));
            return;
        }

        // Two cases for every element
      
        // Include the current element
        curr.add(arr[index]);
        powerSet(arr, index + 1, curr, list);
        
        // Backtrack and exclude the current element
        curr.remove(curr.size() - 1);
        powerSet(arr, index + 1, curr, list);

    }

    // Driver code
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[]{1,2,3}; // Example numeric string
        int index = 0;

        System.out.println("Power set of the Array:");
        powerSet(arr, index, new ArrayList<>(), list);

        System.out.println(list);
   
    }
}


