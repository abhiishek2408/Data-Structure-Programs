import java.util.*;

public class TwoSumPairEfficient {

    // Function to find two indices such that their sum equals target
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i}; // return indices as array
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1}; // return -1 if no pair found
   }


   

    // Main method to test the twoSum function
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        

        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + " " + result[1]);
        } else {
            System.out.println("No two sum solution found");
        }
    }
}

