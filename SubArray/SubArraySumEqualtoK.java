import java.util.*;

public class SubArraySumEqualtoK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int k = 3;

        // Generate all subarrays
        ArrayList<ArrayList<Integer>> subarrays = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            int curr_sum = 0;
            
            for (int j = i; j < arr.length; j++) {
                curr_sum += arr[j];
                
                if (curr_sum == k) {
                    count++;
                }
                
                curr.add(arr[j]);
                subarrays.add(new ArrayList<>(curr));
            }
        }
        
        System.out.println(subarrays);
        System.out.println();
        System.out.println(count);
    }
}
