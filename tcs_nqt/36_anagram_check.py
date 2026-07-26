first = "".join(input().lower().split())
second = "".join(input().lower().split())
print("Anagram" if sorted(first) == sorted(second) else "Not Anagram")
