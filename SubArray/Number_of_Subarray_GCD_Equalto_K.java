
public class Number_of_Subarray_GCD_Equalto_K {
        public int subarrayGCD(int[] nums, int k) {
            int count = 0;
            int n = nums.length;
            
            for (int i = 0; i < n; i++) {
                int currentGCD = 0;
                for (int j = i; j < n; j++) {
                    currentGCD = gcd(currentGCD, nums[j]);
                    if (currentGCD == k) {
                        count++;
                    }
                    // If the current GCD becomes less than k, no need to continue further
                    if (currentGCD < k) {
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
    
        public static void main(String[] args) {
            Number_of_Subarray_GCD_Equalto_K solution = new Number_of_Subarray_GCD_Equalto_K();
            
            // Example test case
            int[] nums = {2, 4, 6, 8, 10};
            int k = 2;
            
            int result = solution.subarrayGCD(nums, k);
            System.out.println("Number of subarrays with GCD " + k + ": " + result);
            
            // You can add more test cases to validate the solution
        }
    }

