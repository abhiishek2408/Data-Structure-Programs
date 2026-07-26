text = input().strip().lower().replace(" ", "")
print("Palindrome" if text == text[::-1] else "Not Palindrome")
