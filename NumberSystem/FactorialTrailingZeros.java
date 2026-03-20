public class FactorialTrailingZeros {
    public static void main(String[] args) {
        int n = 100; 
        int count = 0;

        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        System.out.println("Trailing zeros in " + n + "! : " + count);
    }
}

