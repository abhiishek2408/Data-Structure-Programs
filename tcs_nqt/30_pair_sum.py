n, target = map(int, input().split())
seen = set()
for value in map(int, input().split()):
    if target - value in seen:
        print(target - value, value)
        break
    seen.add(value)
else:
    print(-1)
