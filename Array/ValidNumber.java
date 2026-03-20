package Array;

public class ValidNumber {
    // Function to check if a string is a valid number
    public static boolean isValidNumber(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        int validLC = 0;
        for (int num : arr) {
            validLC = gcd(validLC, Math.abs(num));
        }
        
        return validLC == 1;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    // Example usage
    public static void main(String[] args) {
        int[] testCases =  {5, 10, 15};
       
            System.out.println("ValidNumber: "  + isValidNumber(testCases));
        
    }
}
