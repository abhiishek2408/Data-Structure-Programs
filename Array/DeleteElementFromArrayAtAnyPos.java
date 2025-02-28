public class DeleteElementFromArrayAtAnyPos {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int position = 2; // Position of the element to delete (0-based index)

        if (position < 0 || position >= array.length) {
            System.out.println("Position out of bounds. Unable to delete.");
            return;
        }

        // Shift elements to the left starting from the position + 1
        for (int i = position; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        // Optional: Set the last element to zero (or any default value) after shifting
        array[array.length - 1] = 0;

        // Print the modified array
        System.out.println("\nModified Array:");
        for (int i=0;i<array.length-1;i++) {
            System.out.print(array[i] + " ");
        }
    }
}
