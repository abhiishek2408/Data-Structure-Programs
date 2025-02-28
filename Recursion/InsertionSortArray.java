package Recursion;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortArray {
    
    public static void sort(List<Integer> arr){
        if(arr.size() <= 1)
            return;

        int temp = arr.remove(arr.size() - 1); 
        sort(arr); 
        insert(arr, temp); 
    }

    public static void insert(List<Integer> arr, int val){
        if(arr.isEmpty() || arr.get(arr.size() - 1) <= val){
            arr.add(val);
            return;
        }

        int temp = arr.remove(arr.size() - 1); 
        insert(arr, val); 
        arr.add(temp); 
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(6);
        arr.add(1);
        arr.add(8);
        arr.add(4);

        System.out.println("Original List: " + arr);
        sort(arr);
        System.out.println("Sorted List: " + arr);
    }
}
