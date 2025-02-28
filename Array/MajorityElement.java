import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2};
        
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element in the array
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int n = arr.length;

        // Check if any element appears more than n/2 times
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                System.out.println(key);
                break; // Exit the loop after finding the first majority element
            }
        }
    }
}
