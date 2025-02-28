public class ArrayIntersection {

    public static void intersection(int[] a, int m, int[] b, int n) {

        for (int i = 0; i < m; i++) {
            boolean flag = false;
            
            // Check if the current element of array 'a' is present in array 'b'
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    flag = true; // Mark as found
                    break; // Exit the loop if found
                }
            }
            
            // If the element is found in both arrays, print it
            if (flag) {
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
    
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};
        
     
        int m = a.length;
        int n = b.length;
        
        
        intersection(a, m, b, n);
    }
}
