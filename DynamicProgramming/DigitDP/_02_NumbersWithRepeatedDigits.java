package DynamicProgramming.DigitDP;
import java.util.ArrayList;
public class _02_NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int n) {
        ArrayList<Integer> L = new ArrayList<>();
        for (int x = n + 1; x > 0; x /= 10) L.add(0, x % 10);
        int res = 0, sz = L.size();
        for (int i = 1; i < sz; i++) res += 9 * A(9, i - 1);
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        for (int i = 0; i < sz; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j)) res += A(9 - i, sz - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return n - res;
    }
    public int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }
}