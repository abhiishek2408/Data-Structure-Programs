n = int(input().strip())
matrix = [list(map(int, input().split())) for _ in range(n)]
print(sum(matrix[i][i] for i in range(n)))
