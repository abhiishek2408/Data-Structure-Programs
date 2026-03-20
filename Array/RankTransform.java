import java.util.*;

public class RankTransform {

    public static int[] rankTransform(int[] arr) {

        int n = arr.length;

        // Step 1: Copy array
        int[] temp = arr.clone();

        // Step 2: Sort
        Arrays.sort(temp);

        // Step 3: Assign ranks
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int num : temp) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        // Step 4: Replace values
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {40, 10, 20, 30};

        int[] result = rankTransform(arr);

        System.out.println("Ranked Array: " + Arrays.toString(result));
    }
}
