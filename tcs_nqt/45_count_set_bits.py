n = int(input().strip())
count = 0
while n:
    n &= n - 1
    count += 1
print(count)
