import math

n = int(input().strip())
print("Strong" if sum(math.factorial(int(d)) for d in str(n)) == n else "Not Strong")
