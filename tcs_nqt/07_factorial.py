n = int(input().strip())
answer = 1
for value in range(2, n + 1):
    answer *= value
print(answer)
