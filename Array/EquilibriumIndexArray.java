public class EquilibriumIndexArray {
    public int equilibriumIndex(int[] arr) {

    int total = 0;
    for(int num : arr) total += num;

    int leftSum = 0;

    for(int i = 0; i < arr.length; i++){

        int rightSum = total - leftSum - arr[i];

        if(leftSum == rightSum)
            return i;

        leftSum += arr[i];
    }

    return -1;
}

public static void main(String[] args) {
    EquilibriumIndexArray solution = new EquilibriumIndexArray();
    int[] arr = {-7, 1, 5, 2, -4, 3, 0};
    System.out.println(solution.equilibriumIndex(arr)); // Output: 3
}
}
