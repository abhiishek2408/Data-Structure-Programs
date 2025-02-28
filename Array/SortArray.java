public class SortArray {
    
    public static int[] sortArray(int[] arr){ 
    
        for(int i=0;i<arr.length;i++){
            
                arr[i] = i+1;
                
            
        }
      
      return arr;
        }
    



    public static void main(String[] args) {
        int[] arr = {5, 8, 4, 2, 7};

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        sortArray(arr);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
