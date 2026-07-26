start, end = map(int, input().split())
primes = []
for number in range(max(2, start), end + 1):
    if all(number % divisor for divisor in range(2, int(number ** 0.5) + 1)):
        primes.append(number)
print(*primes)
