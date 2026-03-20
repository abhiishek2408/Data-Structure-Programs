package Array;

// FindSecondLargest.java
// Finds the second largest element in an array

class FindSecondLargest {

    // Returns the second largest element in the array
    static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) { //else if tabhi chalega jab num > largest false ho chuka ho
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 20};
        System.out.println("Second Largest: " + findSecondLargest(arr));
    }
}




/*
### 🔥 **Interview Trick: Find 2nd Largest Element (Hindi + English)**

---

## 🎯 **Core Interview Trick (ONE LINE)**

> **“Largest and second largest dono ko saath-saath track karo — ek hi loop mein.”**

> **Track both largest and second largest together in a single traversal.**

---

## 🧠 **Why Interviewers Love This**

❌ Sorting = `O(n log n)` (slow, extra work)
✅ Single loop = `O(n)` (optimized, smart)

👉 **Shows problem-solving + optimization skills**

---

## 🪜 **Step-by-Step Thinking (Hindi + English)**

### Step 1️⃣: Initialize

**Hindi:**

* Largest aur secondLargest ko sabse chhoti value se initialize karo

**English:**

* Initialize both variables with very small values

```java
int largest = Integer.MIN_VALUE;
int secondLargest = Integer.MIN_VALUE;
```

---

### Step 2️⃣: Traverse Array

**Hindi:**

* Har element ko largest se compare karo

**English:**

* Compare every element with `largest`

---

### Step 3️⃣: If Bigger Than Largest

**Hindi:**

* Agar current element > largest
  → purana largest secondLargest ban jaayega

**English:**

* If current element is greater than largest
  → shift largest to secondLargest

```java
secondLargest = largest;
largest = num;
```

🧠 **Interview Line:**

> “Whenever I find a new maximum, I push the old maximum to second largest.”

---

### Step 4️⃣: Else If (Between Largest & Second)

**Hindi:**

* Agar number largest se chhota hai lekin secondLargest se bada

**English:**

* If number lies between largest and secondLargest

```java
else if (num > secondLargest && num != largest)
```

👉 **Important interview condition:**

> `num != largest` (duplicates avoid karne ke liye)

---

## 🧠 **Real-Life Analogy (INTERVIEW GOLD)**

### 🏆 Race Example

**Hindi:**

* Gold medal = largest
* Silver medal = secondLargest
* Agar koi aur gold jeet leta hai → purana gold silver ban jaata hai

**English:**

* Gold = largest
* Silver = second largest
* If someone beats gold → old gold becomes silver

💬 **Say this in interview — IMPRESS GUARANTEED**

---

## 🚫 **Common Mistakes (Interview Trap)**

| Mistake                          | Why Wrong          |
| -------------------------------- | ------------------ |
| Using sorting                    | Slow & unnecessary |
| Not handling duplicates          | Wrong answer       |
| Only updating secondLargest once | Logical error      |
| Ignoring negative numbers        | Edge case miss     |

---

## ⚡ **Final Interview Answer (READY TO SPEAK)**

> **English:**
> “I solved this by maintaining two variables, largest and second largest, and updating them in a single traversal, which gives O(n) time complexity.”

> **Hindi:**
> “Maine ek hi loop mein largest aur second largest ko track kiya, isse time complexity O(n) ho jaati hai aur sorting ki zarurat nahi padti.”

---

## 🔥 Want Next?

* **Explain why `else if` is needed**
* **Why `num != largest` is important**
* **2nd smallest interview trick**
* **Edge cases interviewer asks**

Just tell me 💯


*/