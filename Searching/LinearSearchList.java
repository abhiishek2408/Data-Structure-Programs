package Searching;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchList {
    public static int linearSearch(List<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i; // Element found
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int target = 30;
        int index = linearSearch(list, target);
        System.out.println("Element found at index: " + index);
    }
}

