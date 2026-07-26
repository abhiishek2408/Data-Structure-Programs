input()
values = list(map(int, input().split()))
leaders, maximum = [], float("-inf")
for value in reversed(values):
    if value >= maximum:
        leaders.append(value)
        maximum = value
print(*reversed(leaders))
