
class ReverseArray {
    void reverse(int[] arr) {
       
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        System.out.print("Reversed Array: ");
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        ReverseArray obj = new ReverseArray();
        int[] arr = {1, 2, 3, 4, 5};
        obj.reverse(arr);
    }
}
