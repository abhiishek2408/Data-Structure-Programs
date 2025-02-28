public class LargestElement {
    
    
    public static int getLargest(int[] arr) {
        int max = 0;  
        for (int i = 1; i < arr.length; i++) {  
            if (arr[i] > arr[max]) { 
                max = i;
            }
        }
        return max;  
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34};  

        int largestIndex = getLargest(arr);

        // Output the result
        System.out.println("The index of the largest element is: " + largestIndex);
        System.out.println("The largest element is: " + arr[largestIndex]);
    }
}
