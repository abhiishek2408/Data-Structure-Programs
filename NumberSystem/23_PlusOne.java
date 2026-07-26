
public class PlusOne {
    
     public int[] plusOne(int[] digits) {
        // Start from the right
        for (int i = digits.length - 1; i >= 0; i--) {
            // If less than 9
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If 9
            digits[i] = 0;
        }
        // If all digits were 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public int[] plusOne2(int[] digits) {

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            digits[i] = sum % 10;
            carry = sum / 10;

            if (carry == 0)
                return digits;
        }

        // Agar last me bhi carry bacha
        int[] result = new int[digits.length + 1];
        result[0] = carry;
        return result;
    }


    // Example usage
    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        int[] digits = {9, 9, 9};
        int[] result = sol.plusOne(digits);
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
