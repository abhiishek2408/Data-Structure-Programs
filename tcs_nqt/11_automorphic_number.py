n = int(input().strip())
print("Automorphic" if str(n * n).endswith(str(n)) else "Not Automorphic")
