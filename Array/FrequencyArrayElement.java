import java.util.*;
public class FrequencyArrayElement {

    public static void printFreqI(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue; //skip if already present

            int freq = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) freq++;
            }
            System.out.println(arr[i] + " " + freq);
        }
    }


    public static void printFreqII() {
        int[] nums = {4, 2, 2, 8, 3, 3, 3, 1, 4, 4, 5, 8, 8};
        boolean[] visited = new boolean[nums.length]; 

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) 
            continue; // Skip if already counted

            int count = 1; // Start count for current element
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    visited[j] = true; // Mark as counted
                }
            }
            System.out.println(nums[i] + " appears " + count + " times");
        }
    }

    public static void printFreqIII() {
        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3, 4, 4};

        HashMap<Integer, Integer> map = new HashMap<>();

        // Calculate frequencies using getOrDefault()
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

        // Print the frequency map
        System.out.println(map);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        int n = arr.length;
        printFreqI(arr, n);
        System.out.println();
        printFreqII();
        System.out.println();
        printFreqIII();
    }
}