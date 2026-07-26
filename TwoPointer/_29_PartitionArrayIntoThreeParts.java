package TwoPointer;

public class _29_PartitionArrayIntoThreeParts {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        if (sum % 3 != 0) return false;
        
        int target = sum / 3;
        int count = 0;
        int currentSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == target) {
                count++;
                currentSum = 0;
            }
        }
        return count >= 3;
    }

    public static void main(String[] args) {
        _29_PartitionArrayIntoThreeParts sol = new _29_PartitionArrayIntoThreeParts();
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println("Can partition into three parts with equal sum? " + sol.canThreePartsEqualSum(arr));
    }
}
