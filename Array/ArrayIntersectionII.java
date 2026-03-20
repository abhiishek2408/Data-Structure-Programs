

class ArrayIntersectionII {

    
    void intersect(int[] a, int[] b) {
        System.out.print("Intersection: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    System.out.print(a[i] + " ");
                    break;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        ArrayIntersectionII solution = new ArrayIntersectionII();

        
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[] b1 = { 4, 5, 6, 7, 2 };

        
        solution.intersect(a1, b1);
    }
}
