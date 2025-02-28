public class InsertElementAtFistInArray {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5};
        int target = 9;
        
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Insert the new element at the first position
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1]; // Shift elements to the right
        }
        
        array[0] = target;

        // Print the modified array
        System.out.println("\nModified Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
