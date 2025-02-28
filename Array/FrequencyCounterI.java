
public class FrequencyCounterI {
    
    public static void main(String[] args) {
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
}
