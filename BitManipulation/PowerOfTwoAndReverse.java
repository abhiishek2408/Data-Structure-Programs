public class PowerOfTwoAndReverse {
    static boolean isPowerOfTwo(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

    static int reverseBits(int number) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = (reversed << 1) | (number & 1);
            number >>>= 1;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("16 is power of two: " + isPowerOfTwo(16));
        System.out.println("18 is power of two: " + isPowerOfTwo(18));
        System.out.println("Reverse of 13: " + Integer.toBinaryString(reverseBits(13)));
    }
}
