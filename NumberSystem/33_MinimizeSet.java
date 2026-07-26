// MinimizeSet.java
// Implements the minimizeSet algorithm as described
// Uses binary search and LCM/GCD logic

public class MinimizeSet {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long left = 1, right = (long) 1e18;
        long lcm = lcm(divisor1, divisor2);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long validForSet1 = mid - mid / divisor1;
            long validForSet2 = mid - mid / divisor2;
            long validForEither = mid - mid / lcm;
            if (validForSet1 >= uniqueCnt1 &&
                validForSet2 >= uniqueCnt2 &&
                validForEither >= uniqueCnt1 + uniqueCnt2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        MinimizeSet sol = new MinimizeSet();
        int divisor1 = 2, divisor2 = 3, uniqueCnt1 = 3, uniqueCnt2 = 3;
        int res = sol.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2);
        System.out.println("Minimized Set Size: " + res);
    }
}
