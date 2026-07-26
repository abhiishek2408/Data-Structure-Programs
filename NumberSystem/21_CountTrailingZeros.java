public class CountTrailingZeros {
    public static void main(String[] args) {
        int num = 12000; // Example input
        int count = 0;

        while (num % 10 == 0 && num != 0) {
            count++;
            num /= 10;
        }

        System.out.println("Trailing zeros: " + count);
    }
}

