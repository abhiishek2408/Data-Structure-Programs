import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {
    
    public static int[] removeDuplicates(int[] arr) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        int n = arr.length;
        
        // Temporary array to store unique elements
        int[] temp = new int[n];
        int newSize = 0;
        
        // Traverse the array
        for (int num : arr) {
            // Add to the set and temp array only if it's not already in the set
            if (!uniqueSet.contains(num)) {
                uniqueSet.add(num);
                temp[newSize] = num;
                newSize++;
            }
        }
        
        // Create result array of exact size
        int[] result = new int[newSize];
        System.arraycopy(temp, 0, result, 0, newSize);
        
        return result;
    }

    public static int removeDuplicatesEfficient(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { 
                nums[k] = nums[i];       
                k++;
            }
        }

        return k; 
    }

    public static void removeDuplicatesFromArrayAndList() {
        // Sample List with Duplicates
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        // 1. Using HashSet (Does not maintain order)
        Set<Integer> set = new HashSet<>(list);
        List<Integer> uniqueList1 = new ArrayList<>(set);
        System.out.println("Using HashSet: " + uniqueList1);

        // 2. Using LinkedHashSet (Maintains order)
        Set<Integer> linkedSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList2 = new ArrayList<>(linkedSet);
        System.out.println("Using LinkedHashSet: " + uniqueList2);

        // 3. Using Streams (Maintains order)
        List<Integer> uniqueList3 = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Using Streams: " + uniqueList3);

        // 4. Removing duplicates from an Array using Streams
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int[] uniqueArr = Arrays.stream(arr).distinct().toArray();
        System.out.println("Using Streams on Array: " + Arrays.toString(uniqueArr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1, 5, 6, 3};
        
        // Call the method to remove duplicates
        int[] result = removeDuplicates(arr);
    
        // Print the result array
        System.out.println("Array after removing duplicates: " + Arrays.toString(result));


        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5};
        int k = removeDuplicatesEfficient(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

