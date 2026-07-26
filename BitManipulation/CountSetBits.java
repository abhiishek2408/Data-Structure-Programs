public class CountSetBits {
    static int countByKernighan(int number) {
        int count = 0;
        while (number != 0) {
            number &= (number - 1); // removes the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 45; // 101101
        System.out.println("Set bits (Kernighan): " + countByKernighan(number));
        System.out.println("Set bits (built-in): " + Integer.bitCount(number));
        System.out.println("Lowest set bit: " + (number & -number));
    }
}
