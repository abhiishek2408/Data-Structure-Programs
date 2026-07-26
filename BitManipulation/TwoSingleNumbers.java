import java.util.Arrays;

public class TwoSingleNumbers {
    // Every value occurs twice except exactly two values.
    static int[] findTwoSingles(int[] numbers) {
        int xor = 0;
        for (int number : numbers) xor ^= number;
        int distinguishingBit = xor & -xor;
        int first = 0, second = 0;
        for (int number : numbers) {
            if ((number & distinguishingBit) == 0) first ^= number;
            else second ^= number;
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoSingles(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
