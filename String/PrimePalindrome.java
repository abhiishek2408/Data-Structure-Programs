package String;

public class PrimePalindrome {

    public int primePalindrome(int n) {
        if (n <= 2) return 2;
        
        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            n++;
            
            // Optimization: No even-length palindromes > 11 can be prime
            if (10_000_000 < n && n < 100_000_000) {
                n = 100_000_000;
            }
        }
    }
    
    private boolean isPalindrome(int x) {
        int original = x, reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return original == reversed;
    }
    
    private boolean isPrime(int x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
       PrimePalindrome solution = new PrimePalindrome();
        int n = 13; // Example input
        System.out.println("Smallest prime palindrome >= " + n + " is: " + solution.primePalindrome(n));
    }
}
