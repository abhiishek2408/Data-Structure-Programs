package Array;


public class _100_CountTriples {
    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int cSquare = a * a + b * b;
                int c = (int) Math.sqrt(cSquare);

                if (c <= n && c * c == cSquare) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        _100_CountTriples solution = new _100_CountTriples();
        int n = 5;
        int result = solution.countTriples(n);
        System.out.println("Number of Pythagorean triples with sides up to " + n + ": " + result);
    }
}
