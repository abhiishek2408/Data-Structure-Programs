package PartitionProblem;
// Hoare Partition Scheme Example
// Partitions the array and returns the pivot index

class HoarePartition {
    public int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HoarePartition hp = new HoarePartition();
        int[] arr = {9, 12, 3, 10, 14, 1, 5};
        int pivotIndex = hp.hoarePartition(arr, 0, arr.length - 1);
        System.out.print("Array after partition: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nPartition index: " + pivotIndex);
    }
}


/*
ज़रूर 👍
नीचे Hoare Partition Scheme को सरल हिंदी + intuition + example के साथ समझाया गया है।


🔹 Hoare Partition क्या है?

👉 **Hoare Partition Scheme** Quick Sort का एक तरीका है, जिसमें:

* Pivot आमतौर पर **पहला element** होता है
* दो pointers (`i` और `j`) **दोनों तरफ़ से चलते हैं**
* गलत जगह पर पड़े elements को **swap** किया जाता है
* Pivot अपनी final sorted position पर **ज़रूरी नहीं** आता
* Function एक **partition index** return करता है

📌 इसे **C. A. R. Hoare** ने बनाया था।

🔹 Hoare Partition का Code (Java)

static int hoarePartition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low - 1;
    int j = high + 1;

    while (true) {

        // left से पहला element जो pivot से बड़ा/बराबर हो
        do {
            i++;
        } while (arr[i] < pivot);

        // right से पहला element जो pivot से छोटा/बराबर हो
        do {
            j--;
        } while (arr[j] > pivot);

        // pointers cross हो गए → partition complete
        if (i >= j)
            return j;

        // गलत जगह वाले elements को swap करो
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## 🔹 Lomuto vs Hoare (Basic Difference)

| Lomuto                  | Hoare                               |
| ----------------------- | ----------------------------------- |
| Pivot = last element    | Pivot = first element               |
| One pointer (`j`)       | Two pointers (`i`, `j`)             |
| Pivot final position पर | Pivot final position पर ज़रूरी नहीं |
| ज़्यादा swaps           | कम swaps (faster)                   |

---

## 🔹 Variables का मतलब

| Variable | मतलब                            |
| -------- | ------------------------------- |
| `pivot`  | जिसके आधार पर array बाँटना है   |
| `i`      | Left से scan करने वाला pointer  |
| `j`      | Right से scan करने वाला pointer |
| `low`    | Sub-array का start              |
| `high`   | Sub-array का end                |

---

## 🔹 Step-by-Step Logic (हिंदी में)

### 1️⃣ Pivot चुनना

```java
int pivot = arr[low];
```

👉 पहला element pivot माना गया है।

---

### 2️⃣ `i` और `j` की शुरुआत

```java
int i = low - 1;
int j = high + 1;
```

* `i` left से बाहर से शुरू करता है
* `j` right से बाहर से शुरू करता है

---

### 3️⃣ `i` को आगे बढ़ाना

```java
do { i++; } while (arr[i] < pivot);
```

👉 जब तक element pivot से **छोटा** है, आगे बढ़ते रहो।

---

### 4️⃣ `j` को पीछे लाना

```java
do { j--; } while (arr[j] > pivot);
```

👉 जब तक element pivot से **बड़ा** है, पीछे आते रहो।

---

### 5️⃣ Pointers cross हुए?

```java
if (i >= j) return j;
```

👉 इसका मतलब:

* Left side में सभी element ≤ pivot
* Right side में सभी element ≥ pivot
* Partition पूरा हो गया ✅

---

### 6️⃣ Swap करना

```java
swap(arr[i], arr[j]);
```

👉 क्योंकि:

* `arr[i]` गलत तरीके से right में है
* `arr[j]` गलत तरीके से left में है

---

## 🔹 Dry Run Example

### Input

```java
arr = [8, 3, 1, 7, 0, 10, 2]
low = 0, high = 6
pivot = 8
```

---

### Steps

1️⃣ `i` → 8 पर रुकता है
2️⃣ `j` → 2 पर रुकता है
3️⃣ Swap → `[2, 3, 1, 7, 0, 10, 8]`

4️⃣ `i` → 10
5️⃣ `j` → 0
6️⃣ Swap → `[2, 3, 1, 7, 8, 10, 0]`

7️⃣ `i >= j` → STOP
Return `j`

---

## 🔹 Final Result (Partitioned)

```java
[2, 3, 1, 7 | 8, 10, 0]
```

Left ≤ pivot
Right ≥ pivot

(क्रम sorted नहीं होता)

---

## 🔹 क्यों Hoare बेहतर माना जाता है?

✅ कम swaps
✅ तेज़ performance
✅ बड़े arrays के लिए अच्छा

---

## 🔹 Interview में बोलने लायक लाइन

> Hoare partition में दो pointers दोनों तरफ़ से चलते हैं और pivot की final position fix नहीं होती, लेकिन swaps कम होने की वजह से यह Lomuto से तेज़ होता है।

---

अगर चाहो तो मैं:

* 🔁 **Hoare vs Lomuto full comparison**
* ❓ **Why return `j` not `i`**
* ⚠️ **Common mistakes**
* ⚡ **Quick Sort using Hoare**

बस बताओ 😊

*/