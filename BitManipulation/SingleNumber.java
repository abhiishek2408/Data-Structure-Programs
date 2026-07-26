public class SingleNumber {
    // All values occur twice except one. Time O(n), extra space O(1).
    static int findSingle(int[] numbers) {
        int answer = 0;
        for (int number : numbers) answer ^= number;
        return answer;
    }

    // All values occur three times except one.
    static int findSingleAmongTriples(int[] numbers) {
        int ones = 0, twos = 0;
        for (int number : numbers) {
            ones = (ones ^ number) & ~twos;
            twos = (twos ^ number) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(findSingle(new int[]{4, 1, 2, 1, 2}));
        System.out.println(findSingleAmongTriples(new int[]{2, 2, 3, 2}));
    }
}
