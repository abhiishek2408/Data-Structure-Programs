import java.util.HashSet;
import java.util.Set;

class DistinctPrimeFactorOfProduct {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactors = new HashSet<>();
        
        for (int num : nums) {
            getPrimeFactors(num, primeFactors);
        }
        
        return primeFactors.size();
    }
    
    private void getPrimeFactors(int num, Set<Integer> primeFactors) {
        // Check for number of 2s that divide num
        while (num % 2 == 0) {
            primeFactors.add(2);
            num /= 2;
        }
        
        // Check for odd factors
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        }
        
        // If num is still greater than 2, it must be prime
        if (num > 1) {
            primeFactors.add(num);
        }
    }
}
