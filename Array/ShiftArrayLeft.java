public class ShiftArrayLeft {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5};
        
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1]; // Shift elements to the left
        }

        
        System.out.println("\nModified Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

