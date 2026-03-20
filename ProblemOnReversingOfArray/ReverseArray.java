class ReverseArray {

    static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    static int[] reverseArray2(int[] arr) {
    int n = arr.length;
    int[] rev = new int[n];

    for (int i = 0; i < n; i++) {
        rev[i] = arr[n - 1 - i];
    }
    return rev;
    }

    static void reverseArray3(int[] arr, int left, int right) {
    if (left >= right) return;

    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    reverseArray3(arr, left + 1, right - 1);
}


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}