public class InsertElementInArrayAtAnyPosition {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int newElement = 99;
        int position = 2; // Desired position (0-based index)

        if (position < 0 || position >= array.length) {
            System.out.println("Position out of bounds. Unable to insert.");
            return;
        }

        // Shift elements to the right starting from the position
        for (int i = array.length - 1; i > position; i--) {
            array[i] = array[i - 1];
        }

        // Insert the new element
        array[position] = newElement;

        // Print the modified array
        System.out.println("Modified Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
