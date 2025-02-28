package Recursion;

import java.util.*;

public class SortStack {

    public static void sort(Stack<Integer> arr) {
        
        if (arr.isEmpty()) {
            return;
        }

        
        int temp = arr.pop();

        
        sort(arr);

        insert(arr, temp);
    }

    public static void insert(Stack<Integer> arr, int val) {
        
        if (arr.isEmpty() || arr.peek() <= val) {
            arr.push(val);
            return;
        }

        
        int temp = arr.pop();
        insert(arr, val);

        
        arr.push(temp);
    }

    public static void main(String[] args) {
        
        Stack<Integer> arr = new Stack<>();
        arr.push(3);
        arr.push(6);
        arr.push(1);
        arr.push(8);
        arr.push(4);

        
        System.out.println("Original Stack: " + arr);

        
        sort(arr);

        
        System.out.println("Sorted Stack: " + arr);
    }
}
