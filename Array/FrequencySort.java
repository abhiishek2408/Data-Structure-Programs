import java.util.*;

public class FrequencySort {

    public static int[] sortByFrequency(int[] arr) {

        // Step 1: Count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert keys to list
        List<Integer> list = new ArrayList<>(map.keySet());

        // Step 3: Sort based on frequency (descending)
        Collections.sort(list, (a, b) -> {
            int freqCompare = map.get(b) - map.get(a);
            if (freqCompare == 0) {
                return a - b; // optional: smaller number first
            }
            return freqCompare;
        });

        // Step 4: Build result
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            int freq = map.get(num);
            for (int i = 0; i < freq; i++) {
                result.add(num);
            }
        }

        // Convert to array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,2,3};

        int[] result = sortByFrequency(arr);

        System.out.println("Sorted by frequency: " + Arrays.toString(result));
    }
}
