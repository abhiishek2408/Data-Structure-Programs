
import java.util.*;

public class AllSubArrayII {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        
        ArrayList<ArrayList<Integer>> subarrays = new ArrayList<>();
    
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                curr.add(arr[j]);
                subarrays.add(new ArrayList<>(curr));
            }
        }
        
        
        System.out.println(subarrays);
        System.out.println();



    }
}
