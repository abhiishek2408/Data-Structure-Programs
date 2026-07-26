n = int(input().strip())
is_prime = n >= 2
for divisor in range(2, int(n ** 0.5) + 1):
    if n % divisor == 0:
        is_prime = False
        break
print("Prime" if is_prime else "Not Prime")
