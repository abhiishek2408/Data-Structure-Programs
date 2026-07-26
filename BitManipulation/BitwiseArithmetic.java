public class BitwiseArithmetic {
    static int add(int first, int second) {
        while (second != 0) {
            int carry = (first & second) << 1;
            first ^= second;
            second = carry;
        }
        return first;
    }

    static int multiplyNonNegative(int first, int second) {
        int answer = 0;
        while (second > 0) {
            if ((second & 1) != 0) answer = add(answer, first);
            first <<= 1;
            second >>>= 1;
        }
        return answer;
    }

    // Returns quotient truncated toward zero.
    static int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("division by zero");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor), quotient = 0;
        for (int bit = 31; bit >= 0; bit--) {
            if ((a >> bit) >= b) {
                a -= b << bit;
                quotient |= 1L << bit;
            }
        }
        return ((dividend < 0) == (divisor < 0)) ? (int) quotient : (int) -quotient;
    }

    public static void main(String[] args) {
        System.out.println("17 + 29 = " + add(17, 29));
        System.out.println("13 * 7 = " + multiplyNonNegative(13, 7));
        System.out.println("43 / -5 = " + divide(43, -5));
    }
}
