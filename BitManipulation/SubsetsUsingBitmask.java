import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsUsingBitmask {
    static List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << numbers.length); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int bit = 0; bit < numbers.length; bit++) {
                if ((mask & (1 << bit)) != 0) subset.add(numbers[bit]);
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(numbers));
        for (List<Integer> subset : subsets(numbers)) System.out.println(subset);
    }
}
