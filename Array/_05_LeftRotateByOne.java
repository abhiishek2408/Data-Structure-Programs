package Array;

public class _05_LeftRotateByOne {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5};
        
        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        int temp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1]; 
        }
        array[array.length - 1] = temp;

        
        System.out.println("\nModified Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

