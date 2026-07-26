input()
seen = set()
result = []
for value in input().split():
    if value not in seen:
        seen.add(value)
        result.append(value)
print(*result)
