binary = bin(int(input().strip()))[2:]
print("Palindrome" if binary == binary[::-1] else "Not Palindrome")
