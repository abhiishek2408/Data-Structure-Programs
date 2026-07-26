package Array;
public class _72_PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] result = new int[n + 1];  
        result[0] = 1; 
        return result;
    }

    public static void main(String[] args) {
        _72_PlusOne solution = new _72_PlusOne();
        int[] digits = {9, 9, 9};
        int[] result = solution.plusOne(digits);
        System.out.println("Result: " + java.util.Arrays.toString(result));
    }
}

