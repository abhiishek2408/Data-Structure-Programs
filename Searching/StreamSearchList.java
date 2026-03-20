package Searching;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamSearchList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        int target = 30;
        Optional<Integer> result = list.stream().filter(num -> num == target).findFirst();

        if (result.isPresent()) {
            System.out.println("Element found: " + result.get());
        } else {
            System.out.println("Element not found.");
        }
    }
}


/*Stream Search (findFirst()) Best Case O(1), Average Case O(n), Worst Case O(n) Works on any list */