import java.util.*;

public class MinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }

        for(int i = 0; i < arr.length - 1; i++) {

            if(arr[i+1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = {4,2,1,3};

        System.out.println(minimumAbsDifference(arr));
    }
}
