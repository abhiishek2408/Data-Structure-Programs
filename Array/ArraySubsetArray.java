import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraySubsetArray {
    
    public boolean isSubset1(int[] arr1, int[] arr2) {

    Set<Integer> set = new HashSet<>();

    // Add all elements of arr1
    for(int num : arr1){
        set.add(num);
    }

    // Check arr2
    for(int num : arr2){
        if(!set.contains(num))
            return false;
    }

    return true;
}


public boolean isSubset2(int[] arr1, int[] arr2) {

    Map<Integer, Integer> freq = new HashMap<>();

    for(int num : arr1){
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    for(int num : arr2){
        if(!freq.containsKey(num) || freq.get(num) == 0)
            return false;

        freq.put(num, freq.get(num) - 1);
    }

    return true;
}

public static void main(String[] args) {
    ArraySubsetArray solution = new ArraySubsetArray();
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {2, 3, 4};
    System.out.println(solution.isSubset1(arr1, arr2)); // Output: true
    System.out.println(solution.isSubset2(arr1, arr2)); // Output: true
}
}