public class Smallest_Even_Multiple {

        public int smallestEvenMultiple(int n) {
            // Check if n is even
            if (n % 2 == 0) {
                return n;
            } else {
                return 2 * n;
            }
        }
    
        public static void main(String[] args) {
            Smallest_Even_Multiple solution = new  Smallest_Even_Multiple();
            
            // Example test cases
            int n1 = 5;
            int result1 = solution.smallestEvenMultiple(n1);
            System.out.println("Smallest even multiple of " + n1 + ": " + result1);  // Output: 10
            
            int n2 = 6;
            int result2 = solution.smallestEvenMultiple(n2);
            System.out.println("Smallest even multiple of " + n2 + ": " + result2);  // Output: 6
            
            // You can add more test cases to validate the solution
        }
    }

