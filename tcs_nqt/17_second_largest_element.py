input()
values = sorted(set(map(int, input().split())), reverse=True)
print(values[1] if len(values) > 1 else -1)
