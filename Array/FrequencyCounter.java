public class FrequencyCounter {

    public static void printFreq(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue; //skip if already present

            int freq = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) freq++;
            }
            System.out.println(arr[i] + " " + freq);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        int n = arr.length;
        printFreq(arr, n);
    }
}