import java.util.HashSet;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1, 5, 6, 3};
        
        // Call the method to remove duplicates
        int[] result = removeDuplicates(arr);

        // Print the result array
        System.out.println("Array after removing duplicates: " + Arrays.toString(result));
    }

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
}

