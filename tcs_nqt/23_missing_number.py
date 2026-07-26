n = int(input().strip())
values = list(map(int, input().split()))
print(n * (n + 1) // 2 - sum(values))
