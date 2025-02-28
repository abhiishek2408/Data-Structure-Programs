public class AddDigit {

    public int addDigits(int n) {
        int dig;
        int num;

        while (n >= 10) { 
            num = 0;
            while (n > 0) {
                dig = n % 10;
                num += dig;
                n = n / 10;
            }
            n = num;
        }   

        return n;
    }

    public static void main(String[] args) {
        AddDigit solution = new AddDigit();
        
        // Test cases
        System.out.println("Result for 38: " + solution.addDigits(38));  // Output: 2
        System.out.println("Result for 0: " + solution.addDigits(0));    // Output: 0
        System.out.println("Result for 12345: " + solution.addDigits(12345));  // Output: 6
        System.out.println("Result for 9999: " + solution.addDigits(9999));  // Output: 9
    }
}

