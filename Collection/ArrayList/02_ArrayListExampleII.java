package Collection.ArrayList;

import java.util.*;

public class ArrayListExampleII {
    public static void main(String[] args) {

// 1. Create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
// 2. Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Initial List: " + list);  //Output: [10, 20, 30]
        
// 3. Access elements
        System.out.println("Element at index 1: " + list.get(1)); //Output: 20
        
// 4. Update an element
        list.set(1, 25);
        System.out.println("After update: " + list);  //Output: [10, 25, 30]
        
// 5. Remove an element
        list.remove(Integer.valueOf(30));
        System.out.println("After removal: " + list); //Output: [10, 25]

// 6. Creating Arraylist with multiple elements
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)); //Output: [10, 20, 30, 40, 50]
        System.out.println("Original List: " + list2);

// 7. Remove the first (top) element
        if (!list2.isEmpty()) {
            list2.remove(0);
        }
        System.out.println("After removing top element: " + list2); //Output: [20, 30, 40, 50]
        
// 8. Check if element exists
        System.out.println("Contains 10? " + list2.contains(10)); //Output: false
        
// 9. Iterate using for loop
        System.out.print("For loop iteration: ");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");  //Output: 20 30 40 50
        }
        System.out.println();
        
// 10. Iterate using enhanced for loop
        System.out.print("Enhanced for loop: ");
        for (Integer num : list2) {
            System.out.print(num + " ");    //Output: 20 30 40 50
        }
        System.out.println();
        
// 11. Iterate using Iterator
        System.out.print("Iterator: ");
        Iterator<Integer> iterator = list2.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");  //Output: 20 30 40 50
        }
        System.out.println();
        
        
// 12. Sort the list
        list2.add(5);
        list2.add(15);
        Collections.sort(list2);     //Output: 5 15 20 30 40 50
        System.out.println("Sorted List: " + list2);
        
        
// 13. Search for an element
        int index = list2.indexOf(15);
        System.out.println("Index of 15: " + index);  //Output: 1
        
        
// 14. Convert list to Array
        Integer[] array = list2.toArray(new Integer[0]);
        System.out.println("Array: " + Arrays.toString(array));

        
// 15. Convert Array to list Using Arrays.asList() (Fixed-size List)
        Integer[] arr = {10, 20, 30, 40, 50};
        List<Integer> list3 = Arrays.asList(arr);
        System.out.println("List: " + list3);
        //⚠️ Warning: Arrays.asList() returns a fixed-size list, so you cannot add or remove elements.

//15.1        
        ArrayList<Integer> list5 = new ArrayList<>();
        for (int num : arr) {
            list5.add(num);
        }
        
// 16. Using new ArrayList<>(Arrays.asList()) (Resizable List)
        Integer[] arr1 = {10, 20, 30, 40, 50};
        List<Integer> list4 = new ArrayList<>(Arrays.asList(arr1));
        list4.add(60); // Now, adding is allowed
        System.out.println("List: " + list4);
        
// 17. Clear the list
        list.clear();
        System.out.println("After clear: " + list);
        
// 18. Check if empty
        System.out.println("Is list empty? " + list.isEmpty());
        
// 19. Add multiple elements at once
        list.addAll(Arrays.asList(40, 50, 60));
        System.out.println("After addAll: " + list);
        
// 20. Remove elements by condition
        list.removeIf(num -> num > 45);
        System.out.println("After removeIf: " + list);
        
// 21. Reverse the list
        Collections.reverse(list);
        System.out.println("Reversed List: " + list);
        
// 22. Shuffle the list
        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);
        
// 23. Get a sublist
        if (list.size() > 1) {
            List<Integer> sublist = list.subList(0, 2);
            System.out.println("Sublist: " + sublist);
        }
        
// 21. Clone the list
        ArrayList<Integer> clonedList = (ArrayList<Integer>) list.clone();
        System.out.println("Cloned List: " + clonedList);
        
// 22. Convert list to stream and filter
        List<Integer> filteredList = list.stream().filter(num -> num > 20).toList();
        System.out.println("Filtered List (greater than 20): " + filteredList);
        
// 23. Find the first element using stream
        list.stream().findFirst().ifPresent(first -> System.out.println("First element: " + first));
        
// 24. Get the size of the list
        System.out.println("Size of the list: " + list.size());
        
// 25. Replace all elements
        list.replaceAll(num -> num * 2);
        System.out.println("After replaceAll (doubled values): " + list);
        
// 26. Remove all elements in another list
        list.removeAll(Arrays.asList(80, 100));
        System.out.println("After removeAll: " + list);
        
// 27. Retain only specific elements
        list.retainAll(Arrays.asList(40));
        System.out.println("After retainAll: " + list);
        
// 28. Check if list contains all elements in another collection
        System.out.println("Contains all [40, 50]? " + list.containsAll(Arrays.asList(40, 50)));
        
// 29. Convert list to LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        System.out.println("Converted to LinkedList: " + linkedList);
        
// 30. Convert list to HashSet
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println("Converted to HashSet: " + set);
        
// 31. Convert list to TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        System.out.println("Converted to TreeSet: " + treeSet);
        
// 32. Check if list is immutable
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + unmodifiableList);
        
// 33. Swap elements
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

