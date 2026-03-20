import java.util.*;

public class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - 1;

        while(right - left + 1 > k) {

            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x))
                left++;
            else
                right--;
        }

        List<Integer> result = new ArrayList<>();

        for(int i = left; i <= right; i++)
            result.add(arr[i]);

        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements(arr,k,x));
    }
}
