input()
values = list(map(int, input().split()))
right = sum(values)
left = 0
for index, value in enumerate(values):
    right -= value
    if left == right:
        print(index)
        break
    left += value
else:
    print(-1)
