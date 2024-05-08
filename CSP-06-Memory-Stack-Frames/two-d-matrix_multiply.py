def multiply_matrices(matrix1, matrix2):
    print("\nMatrix 1:")
    print_matrix(matrix1)
    print("\nMatrix 2:")
    print_matrix(matrix2)

    rows1 = len(matrix1)
    cols1 = len(matrix1[0])
    rows2 = len(matrix2)
    cols2 = len(matrix2[0])

    if cols1 != rows2:
        print("To multiply matrices, matrix1 columns should be equal to the number of the matrix2 rows")
        return None

    result = [[0 for _ in range(cols2)] for _ in range(rows1)]
    # result = [[]]

    # multiplication
    for i in range(rows1):
        for j in range(cols2):
            for k in range(rows2):
                result[i][j] += matrix1[i][k] * matrix2[k][j]

    print("\nResultant Matrix:")
    print_matrix(result)

    return result

def print_matrix(matrix):
    for row in matrix:
        print(" ".join(map(str, row)))

matrixA = [
        [1, 2],
        [3, 4]
    ]
    
matrixB = [
        [5, 6],
        [7, 8]
    ]

multiply_matrices(matrixA, matrixB)