package Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Sorting the list (if not already sorted)
        Collections.sort(list);

        int target = 30;
        int index = Collections.binarySearch(list, target);
        System.out.println("Element found at index: " + index);
    }
}
