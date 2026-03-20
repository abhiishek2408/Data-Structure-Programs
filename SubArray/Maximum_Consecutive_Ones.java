public class Maximum_Consecutive_Ones {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxCount = 0, currentCount = 0;
            
            for (int num : nums) {
                if (num == 1) {
                    currentCount++;
                    maxCount = Math.max(maxCount, currentCount);
                } else {
                    currentCount = 0;
                }
            }
            
            return maxCount;
        }
    
        public static void main(String[] args) {
            Maximum_Consecutive_Ones solution = new Maximum_Consecutive_Ones();
            int[] nums = {1, 1, 0, 1, 1, 1};
            System.out.println("Max Consecutive Ones: " + solution.findMaxConsecutiveOnes(nums));
        }
    }
    
