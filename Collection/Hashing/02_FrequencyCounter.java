package Collection.Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public static void countFreq(int arr[]) {
        HashMap<Integer, Integer> h = new HashMap<>();
        
        for (int x : arr) {
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        countFreq(arr);
    }
}
