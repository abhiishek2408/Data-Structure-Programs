package DynamicProgramming.GameTheoryDP;
import java.util.HashMap;
public class _05_CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        return helper(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }
    private boolean helper(int maxChoosableInteger, int desiredTotal, int state, HashMap<Integer, Boolean> memo) {
        if (desiredTotal <= 0) return false;
        if (memo.containsKey(state)) return memo.get(state);
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((state & (1 << i)) == 0) {
                if (!helper(maxChoosableInteger, desiredTotal - (i + 1), state | (1 << i), memo)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }
        memo.put(state, false);
        return false;
    }
}