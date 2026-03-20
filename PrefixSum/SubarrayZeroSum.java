 

import java.util.*;

public class SubarrayZeroSum {

    public static boolean hasZeroSumSubarray(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        int prefix = 0;

        for(int num : arr) {

            prefix += num;

            if(prefix == 0 || set.contains(prefix))
                return true;

            set.add(prefix);
        }

        return false;
    }

    public static void main(String[] args) {

        int arr[] = {4,2,-3,1,6};

        System.out.println(hasZeroSumSubarray(arr));
    }
}
