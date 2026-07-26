public class BitBasics {
    static boolean isBitSet(int number, int position) {
        return (number & (1 << position)) != 0;
    }

    static int setBit(int number, int position) {
        return number | (1 << position);
    }

    static int clearBit(int number, int position) {
        return number & ~(1 << position);
    }

    static int toggleBit(int number, int position) {
        return number ^ (1 << position);
    }

    public static void main(String[] args) {
        int number = 10; // 1010 in binary
        int position = 2;
        System.out.println("Binary: " + Integer.toBinaryString(number));
        System.out.println("Bit " + position + " set? " + isBitSet(number, position));
        System.out.println("Set bit 2: " + Integer.toBinaryString(setBit(number, position)));
        System.out.println("Clear bit 1: " + Integer.toBinaryString(clearBit(number, 1)));
        System.out.println("Toggle bit 0: " + Integer.toBinaryString(toggleBit(number, 0)));
    }
}
