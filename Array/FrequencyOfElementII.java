import java.util.HashMap;

public class FrequencyOfElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3, 4, 4};

        HashMap<Integer, Integer> map = new HashMap<>();

        // Calculate frequencies using getOrDefault()
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Print the frequency map
        System.out.println(map);
    }
}

