public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
       
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int largest = arr[0];
        int secondLargest = arr[0];

        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;  
                largest = arr[i];         
            }

            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];   
            }
        }
    
        
        if (secondLargest == largest) {
            throw new IllegalArgumentException("No second largest element");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        try {
            int secondLargest = findSecondLargest(arr);
            System.out.println("Second largest element is: " + secondLargest);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
