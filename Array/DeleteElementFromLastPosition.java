public class DeleteElementFromLastPosition {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5};
        int n = array.length;
        
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        
        for (int i = 0; i < n-1; i++) {
            array[i] = array[i+1]; // Shift elements to the left
        }
        
        array[n-1] = 0;// delete the last element 
       

        // Print the modified array
        System.out.println("\nModified Array:");
        for (int i=0;i<n-1;i++) {
            System.out.print(array[i] + " ");
        }
    }
}
