public class UnionOfArray {
    
    
        public static void findUnion(int[] a, int[] b) {
            int[] result = new int[a.length + b.length];
            int i = 0, j = 0, k = 0;
    
            // Traverse both arrays
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    result[k++] = a[i++];
                } else if (a[i] > b[j]) {
                    result[k++] = b[j++];
                } else { // a[i] == b[j]
                    result[k++] = a[i];
                    i++;
                    j++;
                }
            }
    
            // Add remaining elements of 'a' (if any)
            while (i < a.length) {
                result[k++] = a[i++];
            }
    
            // Add remaining elements of 'b' (if any)
            while (j < b.length) {
                result[k++] = b[j++];
            }
    
            // Print the union array
            System.out.print("Union Array: ");
            for (int index = 0; index < k; index++) {
                System.out.print(result[index] + " ");
            }
            System.out.println();
    
            // Print the size of the union
            System.out.println("Size of Union: " + k);
        }
    
        public static void main(String[] args) {
            int[] a = {1, 2, 3, 4};
            int[] b = {3, 4, 5, 6};
    
            findUnion(a, b);
        }
    }
    
