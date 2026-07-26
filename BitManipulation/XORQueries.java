import java.util.Arrays;

public class XORQueries {
    static int[] buildPrefixXor(int[] numbers) {
        int[] prefix = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) prefix[i + 1] = prefix[i] ^ numbers[i];
        return prefix;
    }

    // Inclusive zero-based range [left, right].
    static int rangeXor(int[] prefix, int left, int right) {
        return prefix[right + 1] ^ prefix[left];
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 8};
        int[] prefix = buildPrefixXor(numbers);
        System.out.println("Prefix XOR: " + Arrays.toString(prefix));
        System.out.println("XOR from index 1 to 3: " + rangeXor(prefix, 1, 3));
    }
}
