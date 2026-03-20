class GCD_of_Strings {
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 + str2 equals str2 + str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Find the GCD of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());
        
        // The GCD string is the prefix of str1 (or str2) with length gcdLength
        return str1.substring(0, gcdLength);
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
        GCD_of_Strings solution = new GCD_of_Strings();
        
        // Example test case
        String str1 = "ABCABC";
        String str2 = "ABC";
        
        String result = solution.gcdOfStrings(str1, str2);
        System.out.println("GCD of strings: " + result);  // Output: "ABC"
        
        // You can add more test cases to validate the solution
    }
}