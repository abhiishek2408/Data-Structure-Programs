import java.util.*;

public class TwoSumEfficientSolution {
    public static void main(String[] args) {
        // try all pairs
        int arr[] = {2, 7, 11, 15};
        int n = arr.length;
        int target = 9;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int diff = target - arr[i];
            
            if (map.containsKey(diff)) {
                System.out.println(i + " " + map.get(diff));
            } else {
                map.put(arr[i], i);
            }
        }
    }
}
