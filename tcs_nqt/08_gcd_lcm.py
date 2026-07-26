a, b = map(int, input().split())
x, y = abs(a), abs(b)
while y:
    x, y = y, x % y
lcm = abs(a * b) // x if x else 0
print(x, lcm)
