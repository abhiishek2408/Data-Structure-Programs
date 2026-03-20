public class Number_of_Subarray_LCM_Equalto_K {

        public int subarrayLCM(int[] nums, int k) {
            int count = 0;
            int n = nums.length;
            
            for (int i = 0; i < n; i++) {
                int currentLCM = 1;
                for (int j = i; j < n; j++) {
                    currentLCM = lcm(currentLCM, nums[j]);
                    if (currentLCM == k) {
                        count++;
                    }
                    // If the current LCM exceeds k, no need to continue further
                    if (currentLCM > k) {
                        break;
                    }
                }
            }
            
            return count;
        }
        
        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
        
        private int lcm(int a, int b) {
            if (a == 0 || b == 0) return 0;
            return Math.abs(a * (b / gcd(a, b)));
        }
    
        public static void main(String[] args) {
            Number_of_Subarray_LCM_Equalto_K solution = new Number_of_Subarray_LCM_Equalto_K();
            
            // Example test case
            int[] nums = {2, 3, 4, 6};
            int k = 12;
            
            int result = solution.subarrayLCM(nums, k);
            System.out.println("Number of subarrays with LCM " + k + ": " + result);
            
            // You can add more test cases to validate the solution
        }
    }

