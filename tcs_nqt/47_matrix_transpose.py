rows, cols = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(rows)]
for column in zip(*matrix):
    print(*column)
