package SubSets;
import java.util.*;

public class SubsetsRecursive {
    public static void findSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element
        findSubsets(arr, index + 1, current, result);

        // Include the current element
        current.add(arr[index]);
        findSubsets(arr, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        
        findSubsets(arr, 0, new ArrayList<>(), result);

        System.out.println(result);
    }
}

