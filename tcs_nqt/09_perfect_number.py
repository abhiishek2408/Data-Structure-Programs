n = int(input().strip())
total = 1 if n > 1 else 0
for divisor in range(2, int(n ** 0.5) + 1):
    if n % divisor == 0:
        total += divisor
        if divisor * divisor != n:
            total += n // divisor
print("Perfect" if total == n else "Not Perfect")
