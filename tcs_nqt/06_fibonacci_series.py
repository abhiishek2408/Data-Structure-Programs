n = int(input().strip())
a, b = 0, 1
series = []
for _ in range(n):
    series.append(str(a))
    a, b = b, a + b
print(" ".join(series))
