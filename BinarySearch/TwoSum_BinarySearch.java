package BinarySearch;
class TwoSum_BinarySearch {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;      //two pointers

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i+1, j+1}; 
            } else if (sum > target) {
                j--; 
            } else {
                i++; 
            }
        }

        return new int[]{}; 
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int K = 50;

        System.out.println();

    }
}

