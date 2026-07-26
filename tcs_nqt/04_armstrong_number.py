n = int(input().strip())
digits = str(n)
print("Armstrong" if sum(int(d) ** len(digits) for d in digits) == n else "Not Armstrong")
