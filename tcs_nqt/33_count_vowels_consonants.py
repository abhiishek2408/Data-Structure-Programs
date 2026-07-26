text = input().lower()
vowels = sum(char in "aeiou" for char in text)
consonants = sum(char.isalpha() and char not in "aeiou" for char in text)
print(vowels, consonants)
