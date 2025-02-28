package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;

        // Loop until all digits in num and k are processed
        while (i >= 0 || k > 0) {
            // Start with the carry from the previous addition
            int digit = carry;
            // If there are still digits in num, add the current digit
            if (i >= 0) {
                digit += num[i];
            }
            // If there are still digits in k, add the last digit of k
            if (k > 0) {
                digit += k % 10;
            }
            
            // Calculate the new carry for the next iteration
            carry = digit / 10;
            // Add the current digit (mod 10) to the result list
            result.add(digit % 10);

            // Move to the next digit in k
            k /= 10;
            // Move to the previous digit in num
            i--;
        }

        // If there's a remaining carry, add it to the result
        if (carry > 0) {
            result.add(carry);
        }

        // Reverse the result list to get the correct order
        Collections.reverse(result);
        // Return the result as a list of integers
        return result;
    }
}