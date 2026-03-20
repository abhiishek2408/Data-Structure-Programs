public class ThreeDivisor {

        public boolean isThree(int n) {
            // Calculate the integer square root of n
            int sqrt = (int) Math.sqrt(n);
            
            // Check if n is a perfect square
            if (sqrt * sqrt != n) {
                return false;
            }
            
            // Check if the square root is a prime number
            return isPrime(sqrt);
        }
        
        private boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            if (num <= 3) {
                return true;
            }
            if (num % 2 == 0) {
                return false;
            }
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    
        public static void main(String[] args) {
            ThreeDivisor solution = new ThreeDivisor();
            
            // Example test cases
            int n1 = 9;  // 9 = 3^2, should return true
            System.out.println("Is " + n1 + " having exactly three divisors? " + solution.isThree(n1));
            
            int n2 = 10; // 10 is not a perfect square, should return false
            System.out.println("Is " + n2 + " having exactly three divisors? " + solution.isThree(n2));
            
            // You can add more test cases to validate the solution
        }
    }
