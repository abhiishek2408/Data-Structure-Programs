public class ClosestDivisor {
        public int[] closestDivisors(int num) {
            int[] res1 = findClosestDivisors(num + 1);
            int[] res2 = findClosestDivisors(num + 2);
            
            return (Math.abs(res1[0] - res1[1]) <= Math.abs(res2[0] - res2[1])) ? res1 : res2;
        }
        
        private int[] findClosestDivisors(int num) {
            for (int i = (int) Math.sqrt(num); i > 0; i--) {
                if (num % i == 0) {
                    return new int[]{i, num / i};
                }
            }
            return new int[]{1, num}; // Default case (not really needed as there's always a valid divisor)
        }

        public static void main(String[] args) {
            
        }
}
    

