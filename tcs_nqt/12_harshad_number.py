n = int(input().strip())
digit_sum = sum(map(int, str(abs(n))))
print("Harshad" if digit_sum and n % digit_sum == 0 else "Not Harshad")
