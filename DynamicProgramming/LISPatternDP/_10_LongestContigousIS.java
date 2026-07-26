package DynamicProgramming.LISPatternDP;

        public class _10_LongestContigousIS {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 0) return 0;
    
            int maxLen = 1, curLen = 1;
    
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    curLen++;
                } else {
                    curLen = 1; // Reset when sequence breaks
                }
                maxLen = Math.max(maxLen, curLen);
            }
            return maxLen;
        }
    
        public static void main(String[] args) {
            _10_LongestContigousIS sol = new _10_LongestContigousIS();
            int[] nums = {1, 3, 5, 4, 7};
            System.out.println(sol.findLengthOfLCIS(nums)); // Output: 3
        }
    }
    

