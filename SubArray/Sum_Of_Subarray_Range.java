public class Sum_Of_Subarray_Range {
        public static long subArrayRangesO3(int[] nums) {
            int n = nums.length;
            long sum = 0;
    
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                    
                    // Find min and max in the subarray nums[i:j]
                    for (int k = i; k <= j; k++) {
                        min = Math.min(min, nums[k]);
                        max = Math.max(max, nums[k]);
                    }
                    
                    sum += (max - min);
                }
            }
            return sum;
        }

        public static long subArrayRangesO2(int[] nums) {
            int n = nums.length;
            long sum = 0;
    
            for (int i = 0; i < n; i++) {
                int min = nums[i], max = nums[i];
    
                for (int j = i; j < n; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    
                    sum += (max - min);
                }
            }
            return sum;
        }
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        System.out.println(subArrayRangesO3(arr));
        System.out.println();
        System.out.println(subArrayRangesO2(arr));
        System.out.println();
        System.out.println(subArrayRangesO2(arr));
        System.out.println();

    }
    
}
