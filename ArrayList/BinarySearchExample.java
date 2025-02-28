package ArrayList;

import java.util.*;

public class BinarySearchExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        // The list must be sorted before using binarySearch
        Collections.sort(list);

        int key = 30;
        int index = Collections.binarySearch(list, key);

        if (index >= 0) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

/*The list must be sorted before calling binarySearch().
If the element is found, it returns its index; otherwise, it returns -(insertion point) - 1. */

