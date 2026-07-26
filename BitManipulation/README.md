# Bit Manipulation

This folder progresses from binary fundamentals to interview-level bitmasking and XOR techniques. Every Java file has its own main method, so it can be compiled and run independently:

~~~bash
javac BitBasics.java
java BitBasics
~~~

## Learning order

| File | Topic | Key idea |
|---|---|---|
| BitBasics.java | operators and bit updates | mask a particular position |
| CountSetBits.java | set-bit counting | n & (n - 1) clears one set bit |
| PowerOfTwoAndReverse.java | powers of two and bit reversal | one set bit identifies a power of two |
| SingleNumber.java | XOR fundamentals | equal values cancel with XOR |
| TwoSingleNumbers.java | two unique values | split values using a differing bit |
| SubsetsUsingBitmask.java | generate subsets | each mask represents one subset |
| XORQueries.java | prefix XOR | range XOR in O(1) after preprocessing |
| MaximumXORPair.java | binary trie | greedily choose the opposite bit |
| BitwiseArithmetic.java | addition/division without arithmetic operators | XOR for sum, AND for carry |
| AdvancedBitmaskDP.java | DP over subsets | state is a set of already-selected items |

## Quick reference

For a zero-based bit k and integer n:

~~~text
check bit:    (n & (1 << k)) != 0
set bit:      n | (1 << k)
clear bit:    n & ~(1 << k)
toggle bit:   n ^ (1 << k)
lowest set:   n & -n
remove lowest: n & (n - 1)
~~~

Use long and 1L << k for positions beyond bit 30. Java shifts an int modulo 32, so validate the bit position when input is untrusted.
