package PartitionProblem;
// Lomuto Partition Scheme Example
// Partitions the array and returns the pivot index

class LomutoPartition {
    public int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);   // Swap elements less than pivot to the left side
            }
        }
        swap(arr, i + 1, high);   // Place pivot in the correct position
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LomutoPartition lp = new LomutoPartition();
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int pivotIndex = lp.lomutoPartition(arr, 0, arr.length - 1);
        System.out.print("Array after partition: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nPivot index: " + pivotIndex);
    }
}


/*ज़रूर 👍
यह **Quick Sort का partition function (Lomuto Partition Scheme)** है। इसे मैं **सरल हिंदी + उदाहरण + intuition** के साथ समझा रहा हूँ।

---

## 🔹 इस function का काम क्या है?

👉 Array को **pivot** के आधार पर दो हिस्सों में बाँटना:

* **Pivot से छोटे elements → बाएँ (Left side)**
* **Pivot से बड़े या बराबर elements → दाएँ (Right side)**
* अंत में **pivot अपनी सही position पर आ जाता है**

---

## 🔹 Code (Reference)

```java
private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];   // आखिरी element को pivot बनाया
    int i = low - 1;         // छोटे elements की boundary

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}
```

---

## 🔹 Variables का मतलब (बहुत ज़रूरी)

| Variable | मतलब                                         |
| -------- | -------------------------------------------- |
| `pivot`  | जिसके आधार पर array बाँट रहे हैं             |
| `i`      | Pivot से **छोटे elements की आखिरी position** |
| `j`      | Array को scan करने वाला pointer              |
| `low`    | Sub-array की शुरुआत                          |
| `high`   | Sub-array का अंत                             |

---

## 🔹 Step-by-Step Logic (हिंदी में)

### 1️⃣ Pivot चुनना

```java
int pivot = arr[high];
```

👉 आखिरी element को pivot माना गया है।

---

### 2️⃣ `i = low - 1` क्यों?

```java
int i = low - 1;
```

👉 `i` बताता है:

> “यहाँ तक सारे elements pivot से छोटे हैं”

शुरुआत में कोई भी छोटा element नहीं मिला, इसलिए `low - 1`.

---

### 3️⃣ Loop चलाना (`j`)

```java
for (int j = low; j < high; j++)
```

👉 `j` एक-एक करके elements को देखता है।

---

### 4️⃣ अगर element pivot से छोटा है

```java
if (arr[j] < pivot)
```

तो:

* `i++` (छोटे elements की boundary आगे बढ़ाओ)
* `arr[i]` और `arr[j]` को swap करो

📌 मतलब:

> छोटा element → बाएँ side में डाल दो

---

### 5️⃣ Loop के बाद Pivot को सही जगह रखना

```java
swap(arr[i + 1], arr[high]);
```

👉 अब pivot को उसके **final सही position** पर रखा जाता है।

---

### 6️⃣ Pivot index return करना

```java
return i + 1;
```

👉 यही index आगे Quick Sort recursion में use होता है।

---

## 🔹 Dry Run Example (बहुत important)

### Input

```java
arr = [10, 80, 30, 90, 40, 50, 70]
low = 0, high = 6
pivot = 70
```

---

### Execution Table

| j | arr[j] | arr[j] < pivot | i | Array                        |
| - | ------ | -------------- | - | ---------------------------- |
| 0 | 10     | ✔️             | 0 | [10, 80, 30, 90, 40, 50, 70] |
| 1 | 80     | ❌              | 0 |                              |
| 2 | 30     | ✔️             | 1 | [10, 30, 80, 90, 40, 50, 70] |
| 3 | 90     | ❌              | 1 |                              |
| 4 | 40     | ✔️             | 2 | [10, 30, 40, 90, 80, 50, 70] |
| 5 | 50     | ✔️             | 3 | [10, 30, 40, 50, 80, 90, 70] |

---

### Pivot Swap

```java
swap(arr[4], arr[6])
```

Final array:

```java
[10, 30, 40, 50, 70, 90, 80]
```

Pivot index = **4**

---

## 🔹 Real-Life Analogy

🎯 Pivot = एक standard height
👦 छोटे बच्चे → बाईं लाइन
🧑 बड़े बच्चे → दाईं लाइन

`i` = बाईं लाइन का अंत
`j` = जो बच्चे check हो रहे हैं

---

## 🔹 Time & Space Complexity

| Type           | Value          |
| -------------- | -------------- |
| Partition Time | **O(n)**       |
| Extra Space    | **O(1)**       |
| QuickSort Avg  | **O(n log n)** |

---

## 🔹 Interview में बोलने लायक लाइन

> यह Lomuto partition scheme है, जिसमें आखिरी element को pivot माना जाता है और array को in-place दो हिस्सों में बाँटा जाता है।

---

अगर आप चाहें तो मैं:

* 🔁 **Hoare vs Lomuto comparison**
* ❓ **`i = low - 1` क्यों?**
* ⚡ **इस code को trace करना सिखाऊँ**
* 🧠 **MCQ / viva questions**

बस बताइए 😊
 */