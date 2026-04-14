package DynamicProgramming;
//Problem: Frog Jump
//A frog is crossing a river. The river is divided into x units and at each unit there may or may 
// not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can 
// cross the river by landing on the last stone. Initially, the frog is on the first stone and assume 
// the first jump must be 1 unit. If the frog's last jump was k units, then its next jump must be 
// either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

import java.util.HashMap;
import java.util.HashSet;

public class FrogJumpHard {
    

    public boolean canCross(int[] stones) {
        int n = stones.length;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(1); // first jump must be 1

        for (int stone : stones) {
            for (int jump : map.get(stone)) {

                int reach = stone + jump;

                if (reach == stones[n - 1]) return true;

                if (map.containsKey(reach)) {

                    if (jump - 1 > 0)
                    map.get(reach).add(jump - 1);
                    map.get(reach).add(jump);
                    map.get(reach).add(jump + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FrogJumpHard frogJump = new FrogJumpHard();
        int[] stones1 = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones2 = {0, 1, 2, 3, 4, 8};

        System.out.println("Can the frog cross (stones1)? " + frogJump.canCross(stones1)); // true
        System.out.println("Can the frog cross (stones2)? " + frogJump.canCross(stones2)); // false
    }

}



/*Perfect 👍 — chalo is problem ka **proper dry run** karte hain step-by-step Hindi mein (yeh sabse important part hai samajhne ke liye)

---

# 🧪 Example

```text
stones = [0,1,3,5,6,8,12,17]
```

👉 Target = **17 (last stone)**

---

# 🧠 Step 1: Initialization

👉 Har stone ke liye empty set banate hain:

```text
0 → {}
1 → {}
3 → {}
5 → {}
6 → {}
8 → {}
12 → {}
17 → {}
```

👉 First jump must be 1:

```text
0 → {1}
```

---

# 🔁 Step 2: Start Traversal

---

## 👉 Stone = 0

```text
map[0] = {1}
```

### Jump = 1

```text
reach = 0 + 1 = 1
```

✅ Valid stone

👉 Add next jumps:

```text
k = 1 → (k-1=0 ignore), k=1, k+1=2
```

```text
map[1] = {1,2}
```

---

## 👉 Stone = 1

```text
map[1] = {1,2}
```

---

### Jump = 1

```text
reach = 1 + 1 = 2 ❌ (no stone)
```

---

### Jump = 2

```text
reach = 1 + 2 = 3 ✅
```

👉 Add next jumps:

```text
k=2 → {1,2,3}
```

```text
map[3] = {1,2,3}
```

---

## 👉 Stone = 3

```text
map[3] = {1,2,3}
```

---

### Jump = 1

```text
reach = 3 + 1 = 4 ❌
```

---

### Jump = 2

```text
reach = 3 + 2 = 5 ✅
```

👉 Add:

```text
map[5] = {1,2,3}
```

---

### Jump = 3

```text
reach = 3 + 3 = 6 ✅
```

👉 Add:

```text
map[6] = {2,3,4}
```

---

## 👉 Stone = 5

```text
map[5] = {1,2,3}
```

---

### Jump = 1

```text
reach = 5 + 1 = 6 ✅
```

👉 Add:

```text
map[6] = {1,2,3,4}
```

---

### Jump = 2

```text
reach = 5 + 2 = 7 ❌
```

---

### Jump = 3

```text
reach = 5 + 3 = 8 ✅
```

👉 Add:

```text
map[8] = {2,3,4}
```

---

## 👉 Stone = 6

```text
map[6] = {1,2,3,4}
```

---

### Jump = 1

```text
reach = 6 + 1 = 7 ❌
```

---

### Jump = 2

```text
reach = 6 + 2 = 8 ✅
```

👉 Add:

```text
map[8] = {1,2,3,4}
```

---

### Jump = 3

```text
reach = 6 + 3 = 9 ❌
```

---

### Jump = 4

```text
reach = 6 + 4 = 10 ❌
```

---

## 👉 Stone = 8

```text
map[8] = {1,2,3,4}
```

---

### Jump = 1

```text
reach = 8 + 1 = 9 ❌
```

---

### Jump = 2

```text
reach = 8 + 2 = 10 ❌
```

---

### Jump = 3

```text
reach = 8 + 3 = 11 ❌
```

---

### Jump = 4

```text
reach = 8 + 4 = 12 ✅
```

👉 Add:

```text
map[12] = {3,4,5}
```

---

## 👉 Stone = 12

```text
map[12] = {3,4,5}
```

---

### Jump = 3

```text
reach = 12 + 3 = 15 ❌
```

---

### Jump = 4

```text
reach = 12 + 4 = 16 ❌
```

---

### Jump = 5

```text
reach = 12 + 5 = 17 ✅ 🎯
```

👉 LAST STONE REACHED

---

# 🎉 Final Answer

```text
TRUE ✅
```

---

# 🔥 Important Observations

### 💡 1. Har stone par multiple jumps store ho rahe hain

```text
map[6] = {1,2,3,4}
```

---

### 💡 2. Same stone multiple paths se aa sakta hai

---

### 💡 3. Jump size future ko control karta hai

---

# 🚀 Final Intuition

👉 Tum actually ek graph explore kar rahe ho:

* Node = stone
* Edge = jump

👉 Aur tum track kar rahe ho:

```text
(position, last jump)
```

---

# ⚡ One-Line Summary

👉 **Har stone par possible jumps store karke unhe aage propagate karte hain**

---

Agar tum next level jaana chahte ho:
👉 Main iska **visual tree diagram bana deta hoon (best clarity)**
👉 Ya **memoization recursion version sikha deta hoon**

Batao 👍
 */