package Collection;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> indices = Arrays.asList(1, 3, 5, 7, 9);
        int currentPosition = 4;

        int result = Collections.binarySearch(indices, currentPosition + 1); // Searching for 5

        System.out.println("Result: " + result);
    }
}


/*It means:

indices: This is a List<Integer> that must be sorted in ascending order.
currentPosition + 1: This is the target element you are searching for.

The method will:
Return the index if currentPosition + 1 exists in indices.
Return -(insertionPoint) - 1 if the element is not found, where insertionPoint is the 
index where it would be inserted to maintain sorted order. */