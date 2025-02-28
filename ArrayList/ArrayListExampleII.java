package ArrayList;

import java.util.*;

public class ArrayListExampleII {
    public static void main(String[] args) {
        // 1. Create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
        // 2. Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Initial List: " + list);
        
        // 3. Access elements
        System.out.println("Element at index 1: " + list.get(1));
        
        // 4. Update an element
        list.set(1, 25);
        System.out.println("After update: " + list);
        
        // 5. Remove an element
        list.remove(Integer.valueOf(30));
        System.out.println("After removal: " + list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list2);

        // Remove the first (top) element
        if (!list2.isEmpty()) {
            list2.remove(0);
        }

        System.out.println("After removing top element: " + list);
        
        // 6. Check if element exists
        System.out.println("Contains 10? " + list.contains(10));
        
        // 7. Iterate using for loop
        System.out.print("For loop iteration: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        // 8. Iterate using enhanced for loop
        System.out.print("Enhanced for loop: ");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 9. Iterate using Iterator
        System.out.print("Iterator: ");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        
        // 10. Sort the list
        list.add(5);
        list.add(15);
        Collections.sort(list);
        System.out.println("Sorted List: " + list);
        
        
        // 11. Search for an element
        int index = list.indexOf(15);
        System.out.println("Index of 15: " + index);
        
        
        // 12. Convert list to Array
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println("Array: " + Arrays.toString(array));

        
        //13. Convert Array to list Using Arrays.asList() (Fixed-size List)
        Integer[] arr = {10, 20, 30, 40, 50};
        List<Integer> list3 = Arrays.asList(arr);
        System.out.println("List: " + list3);
        //⚠️ Warning: Arrays.asList() returns a fixed-size list, so you cannot add or remove elements.

        
        //Using new ArrayList<>(Arrays.asList()) (Resizable List)
        Integer[] arr1 = {10, 20, 30, 40, 50};
        List<Integer> list4 = new ArrayList<>(Arrays.asList(arr1));
        list4.add(60); // Now, adding is allowed
        System.out.println("List: " + list4);
        
        // 13. Clear the list
        list.clear();
        System.out.println("After clear: " + list);
        
        // 14. Check if empty
        System.out.println("Is list empty? " + list.isEmpty());
        
        // 15. Add multiple elements at once
        list.addAll(Arrays.asList(40, 50, 60));
        System.out.println("After addAll: " + list);
        
        // 16. Remove elements by condition
        list.removeIf(num -> num > 45);
        System.out.println("After removeIf: " + list);
        
        // 17. Reverse the list
        Collections.reverse(list);
        System.out.println("Reversed List: " + list);
        
        // 18. Shuffle the list
        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);
        
        // 19. Get a sublist
        if (list.size() > 1) {
            List<Integer> sublist = list.subList(0, 2);
            System.out.println("Sublist: " + sublist);
        }
        
        // 20. Clone the list
        ArrayList<Integer> clonedList = (ArrayList<Integer>) list.clone();
        System.out.println("Cloned List: " + clonedList);
        
        // 21. Convert list to stream and filter
        List<Integer> filteredList = list.stream().filter(num -> num > 20).toList();
        System.out.println("Filtered List (greater than 20): " + filteredList);
        
        // 22. Find the first element using stream
        list.stream().findFirst().ifPresent(first -> System.out.println("First element: " + first));
        
        // 23. Get the size of the list
        System.out.println("Size of the list: " + list.size());
        
        // 24. Replace all elements
        list.replaceAll(num -> num * 2);
        System.out.println("After replaceAll (doubled values): " + list);
        
        // 25. Remove all elements in another list
        list.removeAll(Arrays.asList(80, 100));
        System.out.println("After removeAll: " + list);
        
        // 26. Retain only specific elements
        list.retainAll(Arrays.asList(40));
        System.out.println("After retainAll: " + list);
        
        // 27. Check if list contains all elements in another collection
        System.out.println("Contains all [40, 50]? " + list.containsAll(Arrays.asList(40, 50)));
        
        // 28. Convert list to LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        System.out.println("Converted to LinkedList: " + linkedList);
        
        // 29. Convert list to HashSet
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println("Converted to HashSet: " + set);
        
        // 30. Convert list to TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        System.out.println("Converted to TreeSet: " + treeSet);
        
        // 31. Check if list is immutable
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + unmodifiableList);
        
        // 32. Swap elements
        if (list.size() > 1) Collections.swap(list, 0, 1);
        System.out.println("After swapping: " + list);
        
        // 33. Iterate using ListIterator
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        // 34. Convert list to string
        String listString = list.toString();
        System.out.println("List as String: " + listString);
        
        // 35. Ensure capacity
        list.ensureCapacity(50);
        System.out.println("Ensured capacity for 50 elements.");
    }
}

