base, exponent = map(int, input().split())
answer = 1
for _ in range(abs(exponent)):
    answer *= base
print(answer if exponent >= 0 else 1 / answer)
