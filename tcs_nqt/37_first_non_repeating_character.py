from collections import Counter

text = input()
counts = Counter(text)
print(next((char for char in text if counts[char] == 1), -1))
