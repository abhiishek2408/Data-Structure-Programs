package Recursion.Backtracking;

public class NextPermutation {

    private boolean nextPermutation(char[] chars) {
        // Step 1: Find the largest index k such that chars[k] < chars[k + 1]
        int k = chars.length - 2;
        while (k >= 0 && chars[k] >= chars[k + 1]) {
            k--;
        }

        // If no such index exists, the permutation is the last permutation
        if (k < 0) {
            return false;
        }

        // Step 2: Find the largest index l greater than k such that chars[k] < chars[l]
        int l = chars.length - 1;
        while (chars[k] >= chars[l]) {
            l--;
        }

        // Step 3: Swap the characters at indices k and l
        swap(chars, k, l);

        // Step 4: Reverse the sequence from chars[k + 1] to the end
        reverse(chars, k + 1, chars.length - 1);

        return true;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation generator = new NextPermutation();
        char[] chars = {'a', 'b', 'c'};

        System.out.println("Original: " + new String(chars));
        while (generator.nextPermutation(chars)) {
            System.out.println("Next: " + new String(chars));
        }
    }
}
