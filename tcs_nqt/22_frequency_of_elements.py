from collections import Counter

input()
for value, count in sorted(Counter(map(int, input().split())).items()):
    print(value, count)
