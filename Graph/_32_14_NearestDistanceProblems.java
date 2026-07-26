package Graph;

public class _32_14_NearestDistanceProblems {
    /*
    
    # Nearest Distance Problems (Multi-Source BFS)

Is type ke questions me pucha jata hai:

> Har cell/node ke liye nearest source tak minimum distance nikalo.

---

## Example 1: 0-1 Matrix

Grid:

```text
0 0 0
0 1 0
1 1 1
```

Question:

> Har `1` ke liye nearest `0` ka distance nikalo.

Output:

```text
0 0 0
0 1 0
1 2 1
```

---

## Brute Force Approach

Har `1` se BFS chalao aur nearest `0` dhoondo.

```text
1 -> BFS
1 -> BFS
1 -> BFS
...
```

Complexity:

```text
O((m*n)^2)
```

Bahut slow.

---

# Smart Approach: Multi-Source BFS

### Important Observation

Hume nearest `0` chahiye.

Toh BFS har `1` se chalane ki jagah:

**Saare 0s ko source bana do.**

Initially:

```text
0 0 0
0 1 0
1 1 1
```

Queue:

```text
[(0,0), (0,1), (0,2),
 (1,0), (1,2)]
```

Distance of all 0s:

```text
0
```

Ab BFS spread karega.

Jo cell pehli baar visit hoga,
uska distance nearest 0 se minimum hoga.

---

## Dry Run

Initial Distances:

```text
0 0 0
0 - - 
- - -
```

### Level 1

Center `(1,1)` visit

Bottom left `(2,0)`
Bottom right `(2,2)`

Distance:

```text
0 0 0
0 1 0
1 - 1
```

---

### Level 2

Middle bottom `(2,1)`

Distance:

```text
0 0 0
0 1 0
1 2 1
```

Done.

---

# Why Does This Work?

BFS always finds shortest distance.

Since all 0s start together:

```text
Queue = all zeros
```

The first source reaching a cell is automatically the nearest source.

---

# Generic Pattern

Suppose:

```text
S = Sources
X = Other cells
```

```text
S X X X
X X X S
X X X X
```

Put all sources into queue.

```java
for(all source cells){
    queue.add(source);
    dist[source] = 0;
}
```

Then BFS.

---

# Java Template

```java
Queue<int[]> q = new LinkedList<>();

for(int i=0;i<rows;i++){
    for(int j=0;j<cols;j++){

        if(sourceCell){
            q.add(new int[]{i,j});
            dist[i][j] = 0;
        }
        else{
            dist[i][j] = -1;
        }
    }
}

while(!q.isEmpty()){

    int[] cur = q.poll();

    int r = cur[0];
    int c = cur[1];

    for(each neighbour){

        if(dist[nr][nc] == -1){

            dist[nr][nc] =
                dist[r][c] + 1;

            q.add(new int[]{nr,nc});
        }
    }
}
```

---

# Interview Problems Based on This Pattern

1. 01 Matrix
2. As Far from Land as Possible
3. Map of Highest Peak
4. Walls and Gates
5. Nearest Hospital Problem
6. Nearest Police Station Problem
7. Fire Spread Simulation

---

# Recognition Trick

Agar question me likha ho:

* "nearest"
* "minimum distance from any source"
* "closest"
* "distance to nearest X"
* "multiple starting points"

Toh turant socho:

```text
Multi-Source BFS
```

### Formula yaad rakho

```text
Single Source BFS
= One source in queue

Multi-Source BFS
= All sources in queue initially
```

Yehi concept Rotten Oranges, 01 Matrix, Walls & Gates, Highest Peak jaise bahut saare BFS questions ka base hai.

    
    
    */
}
