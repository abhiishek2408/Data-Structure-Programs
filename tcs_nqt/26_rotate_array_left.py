n, k = map(int, input().split())
values = list(map(int, input().split()))
k %= n
print(*(values[k:] + values[:k]))
