package DynamicProgramming;

public class FrogJumpEasy {
    
    public int frogJump(int[] h) {
        int n = h.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int oneStep = dp[i-1] + Math.abs(h[i] - h[i-1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp[i-2] + Math.abs(h[i] - h[i-2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n-1];
    }


    //Space Optimized approach to solve the Frog Jump problem
public int frogJumpSpaceOptimized(int[] h) {
        int n = h.length;

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = 1; i < n; i++) {

            int oneStep = prev1 + Math.abs(h[i] - h[i-1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = prev2 + Math.abs(h[i] - h[i-2]);
            }

            int curr = Math.min(oneStep, twoStep);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

public static void main(String[] args) {
    
    FrogJumpEasy frogJump = new FrogJumpEasy();
    int[] h = {10, 30, 40, 20};
    int result = frogJump.frogJump(h);
    System.out.println("Minimum energy required for the frog to jump: " + result);
}

}



/*
Chalo ab isko **step-by-step dry run** se solid bana dete hain 🔥
Main **Example 1** le raha hoon:

---

# 📌 Input

```
n = 4
costs = [1, 2, 3, 4]
```

👉 Yaad rakho:

* `costs[i-1]` = step `i` ka cost

---

# 🧠 DP Definition

👉 `dp[i] = minimum cost to reach step i`

---

# 🚀 Initialization

```
dp[0] = 0
```

---

# 🔁 Step-by-Step Dry Run

---

## 👉 i = 1

Step 1 par pahuchne ke options:

### ✔️ from 0 → 1

```
dp[0] + cost[1] + 1^2
= 0 + 1 + 1
= 2
```

✅ Final:

```
dp[1] = 2
```

---

## 👉 i = 2

Options:

### ✔️ from 1 → 2

```
dp[1] + cost[2] + 1
= 2 + 2 + 1 = 5
```

### ✔️ from 0 → 2

```
dp[0] + cost[2] + 4
= 0 + 2 + 4 = 6
```

✅ Minimum:

```
dp[2] = 5
```

---

## 👉 i = 3

Options:

### ✔️ from 2 → 3

```
dp[2] + cost[3] + 1
= 5 + 3 + 1 = 9
```

### ✔️ from 1 → 3

```
dp[1] + cost[3] + 4
= 2 + 3 + 4 = 9
```

### ✔️ from 0 → 3

```
dp[0] + cost[3] + 9
= 0 + 3 + 9 = 12
```

✅ Minimum:

```
dp[3] = 9
```

---

## 👉 i = 4

Options:

### ✔️ from 3 → 4

```
dp[3] + cost[4] + 1
= 9 + 4 + 1 = 14
```

### ✔️ from 2 → 4

```
dp[2] + cost[4] + 4
= 5 + 4 + 4 = 13
```

### ✔️ from 1 → 4

```
dp[1] + cost[4] + 9
= 2 + 4 + 9 = 15
```

✅ Minimum:

```
dp[4] = 13
```

---

# 🎯 Final Answer

```
dp[4] = 13
```

---

# 📊 DP Table Summary

| i | dp[i] |
| - | ----- |
| 0 | 0     |
| 1 | 2     |
| 2 | 5     |
| 3 | 9     |
| 4 | 13    |

---

# 🧠 Best Path kaise mila?

Backtrack karo:

```
dp[4] = dp[2] + jump(2→4)
dp[2] = dp[1] + jump(1→2)
dp[1] = dp[0] + jump(0→1)
```

👉 Path:

```
0 → 1 → 2 → 4
```

---

# 💡 Key Observation

* Har step par sirf **last 3 values** important hain
* Tum hamesha **minimum path choose kar rahe ho**

---

Agar tum chaho next:

👉 main iska **visual diagram (graph style)** bana du
👉 ya **Example 2 ka dry run bhi karva du (thoda tricky hai)**


*/