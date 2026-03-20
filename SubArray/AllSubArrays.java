
public class AllSubArrays {

    public static void displayAllSubArrays(int[] array) {
        int n = array.length;
        
        // Loop for starting point
        for (int start = 0; start < n; start++) {
            // Loop for ending point
            for (int end = start; end < n; end++) {
                // Print subarray from start to end
                System.out.print("[");
                for (int k = start; k <= end; k++) {
                    System.out.print(array[k]);
                    if (k < end) {
                        System.out.print(", ");
                    }
                }
                System.out.print("], ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        displayAllSubArrays(array);
    }
}