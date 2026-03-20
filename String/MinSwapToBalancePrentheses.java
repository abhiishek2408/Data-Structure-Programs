package String;

public class MinSwapToBalancePrentheses {
        public int minSwaps(String s) {
            int open = 0, close = 0;
            
            // Count the number of misplaced closing brackets
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    open++;
                } else {
                    if (open > 0) {
                        open--;
                    } else {
                        close++;
                    }
                }
            }
            
            // The number of swaps needed is (close + 1) / 2
            return (close + 1) / 2;
        }
    
        public static void main(String[] args) {
            MinSwapToBalancePrentheses  solution = new MinSwapToBalancePrentheses ();
            System.out.println(solution.minSwaps("][][")); // Output: 1
            System.out.println(solution.minSwaps("]]]][[[[")); // Output: 2
            System.out.println(solution.minSwaps("[]")); // Output: 0
        }
    }
    

