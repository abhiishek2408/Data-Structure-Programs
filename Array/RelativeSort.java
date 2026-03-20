import java.util.*;

public class RelativeSort {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        // Step 2: Place elements from arr2
        for (int num : arr2) {
            int count = freq.getOrDefault(num, 0);

            while (count-- > 0) {
                arr1[index++] = num;
            }

            freq.remove(num);
        }

        // Step 3: Remaining elements
        List<Integer> remaining = new ArrayList<>();

        for (int key : freq.keySet()) {
            int count = freq.get(key);
            while (count-- > 0) {
                remaining.add(key);
            }
        }

        Collections.sort(remaining);

        for (int num : remaining) {
            arr1[index++] = num;
        }

        return arr1;
    }

    public static void main(String[] args) {

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        int[] result = relativeSortArray(arr1, arr2);

        System.out.println("Sorted Array: " + Arrays.toString(result));
    }
}
