public class GCD_of_Array {

        public int findGCD(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("Array must not be null or empty");
            }
            
            int min = nums[0];
            int max = nums[0];
            
            // Find the minimum and maximum values in the array
            for (int num : nums) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
            
            // Calculate the GCD of the smallest and largest numbers
            return gcd(min, max);
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
            GCD_of_Array solution = new GCD_of_Array();
            
            // Example test case
            int[] nums = {2, 5, 6, 9, 10};
            
            int result = solution.findGCD(nums);
            System.out.println("GCD of the smallest and largest numbers: " + result);
            
            // You can add more test cases to validate the solution
        }
    }

