input()
values = list(map(int, input().split()))
print(*([x for x in values if x != 0] + [0] * values.count(0)))
