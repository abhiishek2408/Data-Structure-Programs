package ArrayList;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        // 1. Create an ArrayList
        ArrayList<String> list = new ArrayList<>();
        
        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("1- Initial List: " + list);
        System.out.println();
        
        // 3. Access elements
        System.out.println("2- Element at index 1: " + list.get(1));
        System.out.println();
        
        // 4. Update an element
        list.set(1, "Blueberry");
        System.out.println("3- After update: " + list);
        System.out.println();
        
        // 5. Remove an element
        list.remove("Cherry");
        System.out.println("4- After removal: " + list);
        System.out.println();
        
        // 6. Check if element exists
        System.out.println("5- Contains Apple? " + list.contains("Apple"));
        System.out.println();
        
        // 7. Iterate using for loop
        System.out.print("6- For loop iteration: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        // 8. Iterate using enhanced for loop (foreach loop)
        System.out.print("7- Enhanced for loop: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // 9. Iterate using Iterator
        System.out.print("8-Iterator: ");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();
        
        // 10. Sort the list
        list.add("Mango");
        list.add("Orange");
        Collections.sort(list);
        System.out.println("9- Sorted List: " + list);
        System.out.println();
        
        // 11. Search for an element
        int index = list.indexOf("Mango");
        System.out.println("10- Index of Mango: " + index);
        System.out.println();
        
        // 12. Convert to Array
        String[] array = list.toArray(new String[0]);
        System.out.println("11- Array: " + Arrays.toString(array));
        System.out.println();
        
        // 13. Clear the list
        list.clear();
        System.out.println("12- After clear: " + list);
        System.out.println();
        
        // 14. Check if empty
        System.out.println("13- Is list empty? " + list.isEmpty());
        System.out.println();
        
        // 15. Add multiple elements at once
        list.addAll(Arrays.asList("Grapes", "Pineapple", "Watermelon"));
        System.out.println("14- After addAll: " + list);
        System.out.println();
        
        // 16. Remove elements by condition
        list.removeIf(fruit -> fruit.startsWith("P"));
        System.out.println("15- After removeIf: " + list);
        
        // 17. Reverse the list
        Collections.reverse(list);
        System.out.println("16- Reversed List: " + list);
        
        // 18. Shuffle the list
        Collections.shuffle(list);
        System.out.println("17- Shuffled List: " + list);
        
        // 19. Get a sublist
        if (list.size() > 1) {
            List<String> sublist = list.subList(0, 2);
            System.out.println("18- Sublist: " + sublist);
        }
        
        // 20. Clone the list
        ArrayList<String> clonedList = (ArrayList<String>) list.clone();
        System.out.println("Cloned List: " + clonedList);
        
        // 21. Convert list to stream and filter
        List<String> filteredList = list.stream().filter(fruit -> fruit.length() > 5).toList();
        System.out.println("Filtered List (length > 5): " + filteredList);
        
        // 22. Find the first element using stream
        list.stream().findFirst().ifPresent(first -> System.out.println("First element: " + first));
        
        // 23. Get the size of the list
        System.out.println("Size of the list: " + list.size());
        
        // 24. Replace all elements
        list.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll: " + list);
        
        // 25. Remove all elements in another list
        list.removeAll(Arrays.asList("GRAPES", "WATERMELON"));
        System.out.println("After removeAll: " + list);
        
        // 26. Retain only specific elements
        list.retainAll(Arrays.asList("APPLE"));
        System.out.println("After retainAll: " + list);
        
        // 27. Check if list contains all elements in another collection
        System.out.println("Contains all [APPLE, MANGO]? " + list.containsAll(Arrays.asList("APPLE", "MANGO")));
        
        // 28. Convert list to LinkedList
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println("Converted to LinkedList: " + linkedList);
        
        // 29. Convert list to HashSet
        HashSet<String> set = new HashSet<>(list);
        System.out.println("Converted to HashSet: " + set);
        
        // 30. Convert list to TreeSet
        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println("Converted to TreeSet: " + treeSet);
        
        // 31. Check if list is immutable
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + unmodifiableList);
        
        // 32. Swap elements
        if (list.size() > 1) Collections.swap(list, 0, 1);
        System.out.println("After swapping: " + list);
        
        // 33. Iterate using ListIterator
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        // 34. Convert list to string
        String listString = String.join(", ", list);
        System.out.println("List as String: " + listString);
        
        // 35. Ensure capacity
        list.ensureCapacity(50);
        System.out.println("Ensured capacity for 50 elements.");
    }
}
