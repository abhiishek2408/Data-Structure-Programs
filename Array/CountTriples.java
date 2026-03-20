package Array;


class Solution {
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
        Solution sol = new Solution();
        int n = 5;
        int result = sol.countTriples(n);
        System.out.println("Number of Pythagorean triples with sides up to " + n + ": " + result);
    }
}
