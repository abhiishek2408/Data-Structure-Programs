
class ArrayIntersectionIII {

    public static void findIntersection(int[] a, int[] b) {
        int[] result = new int[Math.min(a.length, b.length)]; // Step 1
        int i = 0, j = 0, k = 0; // Step 2

        // Step 3: Traverse both arrays
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) { // Step 3.1
                i++;
            } else if (a[i] > b[j]) { // Step 3.2
                j++;
            } else { // Step 3.3: a[i] == b[j]
                result[k++] = a[i];
                i++;
                j++;
            }
        }

        // Step 4: Print the intersection array
        System.out.print("Intersection Array: ");
        for (int index = 0; index < k; index++) {
            System.out.print(result[index] + " ");
        }
        System.out.println();

        // Step 5: Print the size of the intersection
        System.out.println("Size of Intersection: " + k);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 5, 6};

        findIntersection(a, b);
    }
}

