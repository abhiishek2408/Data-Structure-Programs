package PartitionProblem;

/*
Very good question 👍
This line is **the heart of the algorithm**, so let’s understand it **deeply but simply**.

---

## 🔹 Why `while (left <= right)` ?

### Short Answer (Interview-ready)

> We continue the loop **until both pointers cross**, because once `left > right`, **all elements are already partitioned correctly**.

---

## 🔹 What do `left` and `right` mean?

* `left` → searches for an element **≥ pivot** (wrong on left side)
* `right` → searches for an element **< pivot** (wrong on right side)

They move **towards each other**.

---

## 🔹 Key Rule

👉 **As long as `left` has not crossed `right`, there may still be elements in the wrong position.**

So we must keep looping.

---

## 🔹 What happens when pointers cross?

```
left > right
```

This means:

* All elements **before `left`** are `< pivot`
* All elements **after `right`** are `>= pivot`
* No element is left to check ❌

✅ Partition is complete
🚫 Loop must stop

---

## 🔹 Visual Understanding

### Example

```java
arr = [9, 12, 3, 5, 14, 10, 7]
pivot = 10
```

Final stage:

```
Index:  0  1  2  3 | 4   5   6
Array: [9, 7, 3, 5 |14, 10, 12]
              ↑
            left
          right
```

Now:

```
left = 4
right = 3
left > right  → STOP
```

Nothing left to swap or check.

---

## 🔹 Why NOT `while (left < right)` ?

This is **very important**.

### ❌ Problem with `left < right`

* It **skips the case when `left == right`**
* The middle element may never be checked
* Can leave one element unprocessed

### Example

```java
arr = [11]
pivot = 10
```

* `left = 0`, `right = 0`
* `left < right` → ❌ false → loop never runs
* But element **still needs checking**

👉 `left <= right` handles this correctly.

---

## 🔹 Why the same condition inside inner loops?

```java
while (left <= right && arr[left] < pivot)
while (left <= right && arr[right] >= pivot)
```

### Reason:

* Prevent **array index out of bounds**
* Stop pointer movement **after crossing**
* Maintain correctness when array size is odd

---

## 🔹 Final Intuition (Best Way to Remember)

🧠 Think like this:

> “Keep working **until both guards meet or cross**.
> After crossing, nothing remains unchecked.”

---

## 🔹 One-Line Explanation (Perfect for Viva / Interview)

> `while (left <= right)` ensures that all elements are processed until both pointers cross, guaranteeing correct partitioning without missing any element.

---

If you want, I can also explain:

* 🔁 **What breaks if we remove `<=`**
* ✍️ **Dry run only for this condition**
* ⚡ **Difference between partition, Dutch flag, and quicksort**

Just say 👍

*/

//3-way partition + stable order
// Order strictly:
//All elements < pivot
//All elements == pivot
//All elements > pivot


public class PartitionArrayAroundPivot {
        // Returns a new array partitioned around the pivot: <pivot, ==pivot, >pivot
        public static int[] pivotArray(int[] nums, int pivot) {
            int n = nums.length;
            int[] res = new int[n];
            int idx = 0;
            // First pass: elements less than pivot
            for (int num : nums) {
                if (num < pivot) res[idx++] = num;
            }
            // Second pass: elements equal to pivot
            for (int num : nums) {
                if (num == pivot) res[idx++] = num;
            }
            // Third pass: elements greater than pivot
            for (int num : nums) {
                if (num > pivot) res[idx++] = num;
            }
            return res;
    }

    // Function to partition array around a given pivot value (returns the modified array)
    // using two-pointer approach
    // order of elements is not maintained
    public static int[] partition(int[] arr, int pivot) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {9, 12, 3, 10, 14, 1, 5};
        int pivot = 10;
        System.out.println("Original array:");
        printArray(arr);
        partition(arr, pivot);
        System.out.println("Array after partitioning around pivot " + pivot + ":");
        printArray(arr);
    }
}


/*
Excellent question 👌
This shows you’re thinking about **edge cases**, which interviewers love.

---

## 🔹 Why do we write

```java
while (left <= right && arr[left] < pivot)
```

instead of

```java
while (arr[left] < pivot)
```

---

## 🔹 Short Answer (Core Reason)

👉 **To prevent `left` from crossing `right` and accessing invalid or already-processed elements.**

---

## 🔹 What problem can happen WITHOUT `left <= right`?

### Consider this scenario 👇

```java
arr = [1, 2, 3]
pivot = 10
```

All elements are `< pivot`.

---

### Step-by-step WITHOUT `left <= right`

```java
left = 0, right = 2

arr[left] < pivot → left++
arr[left] < pivot → left++
arr[left] < pivot → left++
```

Now:

```
left = 3
right = 2
```

🚨 `left` is now **outside the array**
Next access: `arr[left]` → ❌ ArrayIndexOutOfBoundsException

---

## 🔹 How `left <= right` fixes this

```java
while (left <= right && arr[left] < pivot)
```

* As soon as `left` becomes **greater than `right`**
* The condition fails
* Loop **stops safely**

✅ No crash
✅ Correct logic

---

## 🔹 Logical Meaning (Very Important)

`left <= right` means:

> “Only keep checking **unprocessed elements**”

Once `left > right`:

* The partition is already complete
* Anything beyond that is irrelevant

---

## 🔹 Real-Life Analogy

🧍‍♂️ Left guard checking people from start
🧍‍♂️ Right guard checking people from end

Once they **cross**, there is:

* No one left to inspect
* Guards must stop checking

---

## 🔹 Why this condition is ALSO needed for correctness (not just safety)

Without `left <= right`:

* `left` may move too far
* Later swap logic may behave incorrectly
* Edge cases (odd-length arrays) break

---

## 🔹 Why SAME condition in right loop?

```java
while (left <= right && arr[right] >= pivot)
```

👉 For **exactly the same reasons**:

* Prevent invalid access
* Avoid re-checking processed elements

---

## 🔹 Interview-Perfect One-Liner

> `left <= right` ensures that pointer movement happens only within the valid, unprocessed portion of the array, preventing out-of-bounds access and guaranteeing correct partitioning.

---

## 🔹 Key Takeaway 🧠

**Pointer crossing = work done**
So every inner loop must stop **before or at crossing**

---

If you want, I can:

* 🔁 Show a **case where removing it breaks output**
* ✍️ Rewrite code **without this condition and debug it**
* ⚡ Compare with **Dutch National Flag approach**

Just tell me 👍



*/