package SlidingWindow;

import java.util.HashMap;

public class _26_FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int i = 0, j = 0, max = 0;

        while (j < fruits.length) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);

            while (count.size() > 2) {
                count.put(fruits[i], count.get(fruits[i]) - 1);
                if (count.get(fruits[i]) == 0) {
                    count.remove(fruits[i]);
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        _26_FruitIntoBaskets sol = new _26_FruitIntoBaskets();
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println("Maximum fruits in baskets: " + sol.totalFruit(fruits));
    }
}
