package TwoPointer;

import java.util.Arrays;

public class _28_BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int boats = 0;
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        _28_BoatsToSavePeople sol = new _28_BoatsToSavePeople();
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println("Minimum boats: " + sol.numRescueBoats(people, limit));
    }
}
