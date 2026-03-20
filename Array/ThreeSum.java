package Array;

import java.util.*;

public class ThreeSum {
    // Returns a list of all unique triplets [a, b, c] such that a + b + c = 0
   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Fix first element one by one
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            // Step 3: Two pointer approach
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;   // increase sum
                } 
                else {
                    right--;  // decrease sum
                }
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = new ThreeSum().threeSum(nums);
        System.out.println("Unique triplets that sum to 0: " + triplets);
    }
}



/*Ah! Ye **important line** hai 3 Sum me, main **step-by-step Hindi me explain** karta hoon:

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

---

## 🔹 Meaning

1. `i > 0` → ye check karta hai ki hum **first element se pehle na jaayein** (0th index pe `i-1` invalid hoga)
2. `nums[i] == nums[i - 1]` → agar **current element** previous element ke **barabar** hai

> iska matlab: hum **duplicate element pe work kar rahe hain**

3. `continue` → iska matlab hai **loop ke next iteration pe jump karo**, yani ye element skip kar do

---

## 🔹 Why we need it?

### Problem: Avoid Duplicate Triplets

* Array sorted hai
* Agar `nums[i]` previous element ke **barabar** hai → same first element se triplet firse ban jayega → duplicate result

---

### Example:

```java
nums = [-1, -1, 0, 1, 2]
```

* i = 0 → nums[i] = -1 → first triplets banenge
* i = 1 → nums[i] = -1 → **same as previous**

  * Agar skip nahi karenge → triplets repeat ho jaayenge
  * `[-1, 0, 1]` pehle se aa chuka hai → duplicate add ho jayega

---

## 🔹 Key Takeaway

> Ye line **duplicate triplets avoid karne ke liye mandatory hai**

* Sorting ki wajah se adjacent duplicates easily detect ho jaate hain
* First element fix karte waqt **previous element same hai → skip**

---

Agar chaho, main **left & right pointer ke duplicates skip logic** bhi **Hindi me step-by-step** samjha doon, jisse **pure 3 Sum duplicates kaise handle hote hain** clear ho jaaye.

Kya main wo bhi bata doon?
 */