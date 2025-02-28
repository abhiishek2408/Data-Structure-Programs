public class DeleteElementFromFirstPosition {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5};
        int n = array.length;
        
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        
        for (int i = n - 1; i > 0; i--) {
            array[i] = array[i - 1]; // Shift elements to the right
        }
        
        array[0] = 0;// delete the first element 
       

        // Print the modified array
        System.out.println("\nModified Array:");
        for (int i=1;i<=n-1;i++) {
            System.out.print(array[i] + " ");
        }
    }
}

