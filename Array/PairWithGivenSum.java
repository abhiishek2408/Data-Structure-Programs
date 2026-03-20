package Array;
// Problem: Find all pairs in an array whose sum equals a given value
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class PairWithGivenSum {
    // Prints all pairs in arr[] with sum equal to target

    public static void pairSumBrute(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == k) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }
  }

    public static void pairSumHash(int[] arr, int k) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : arr) {
        int target = k - num;

        if (set.contains(target)) {
            System.out.println(num + ", " + target);
        }

        set.add(num);
    }
  }

   

public static void pairSumTwoPointer(int[] arr, int k) {
    Arrays.sort(arr);

    int left = 0, right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == k) {
            System.out.println(arr[left] + ", " + arr[right]);
            left++;
            right--;
        } else if (sum < k) {
            left++;
        } else {
            right--;
        }
    }
  }


    public static void printPairs(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Pairs with sum " + target + ":");
        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                int count = map.get(complement);
                for (int i = 0; i < count; i++) {
                    System.out.println("(" + complement + ", " + num + ")");
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        printPairs(arr, target);

    }
}



/*
### 🔹 HashSet approach ka **simple analogy** (easy Hindi 😄)

Socho:

🧺 **Tumhare paas ek bag (HashSet)** hai
📦 Tum ek-ek karke numbers **bag me daalte ja rahe ho**

Target sum = **k**

---

### 🧠 Real-life Analogy (Dukaan wali)

Socho tum ek **₹10 ka note banana chahte ho**
Aur tumhare paas coins aate ja rahe hain:

Array = `[8, 7, 2, 5, 3, 1]`
k = `10`

---

### Step-by-step samjho 👇

#### 🔸 Step 1: num = 8

* Socho: “Mujhe 10 banana hai”
* Check: `10 - 8 = 2`
* Bag me 2 hai? ❌
  ➡️ 8 ko bag me daal diya

🧺 Bag = `{8}`

---

#### 🔸 Step 2: num = 7

* Check: `10 - 7 = 3`
* Bag me 3 hai? ❌
  ➡️ 7 ko bag me daal diya

🧺 Bag = `{8, 7}`

---

#### 🔸 Step 3: num = 2

* Check: `10 - 2 = 8`
* Bag me 8 hai? ✅
  🎉 **Pair mil gaya → (2, 8)**

➡️ 2 ko bag me daal diya

🧺 Bag = `{8, 7, 2}`

---

#### 🔸 Step 4: num = 5

* Check: `10 - 5 = 5`
* Bag me 5 hai? ❌
  ➡️ 5 add

🧺 Bag = `{8, 7, 2, 5}`

---

#### 🔸 Step 5: num = 3

* Check: `10 - 3 = 7`
* Bag me 7 hai? ✅
  🎉 **Pair → (3, 7)**

---

### 🔑 Core Idea (One Line)

> **Har number ke liye uska “partner” (k − num) pehle dekha hai ya nahi — bas ye check karna hai**

---

### 🤯 Why HashSet?

* HashSet **yaad rakh leta hai** jo numbers pehle aaye
* `contains()` check = **bahut fast (O(1))**

---

### 🧠 Code ko analogy me map karo

```java
HashSet<Integer> set = new HashSet<>();
```

🧺 → bag

```java
int target = k - num;
```

🤔 → "Is number ke saath kaunsa number chahiye?"

```java
if (set.contains(target))
```

👀 → "Kya wo number pehle aa chuka hai?"

```java
set.add(num);
```

📦 → "Is number ko future ke liye yaad rakh lo"

---

### ⭐ Interview me bolne layak line

> “We store visited elements in a HashSet and for each element, we check whether its complement (k − element) already exists.”

Agar chaho to main **duplicate case**, **count pairs**, ya **LeetCode problem dry run** bhi kara deta hoon 👍


*/