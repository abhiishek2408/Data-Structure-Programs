words = input().split()
print(max(words, key=len) if words else "")
