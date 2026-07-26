input()
seen = set()
for value in map(int, input().split()):
    if value in seen:
        print(value)
        break
    seen.add(value)
else:
    print(-1)
