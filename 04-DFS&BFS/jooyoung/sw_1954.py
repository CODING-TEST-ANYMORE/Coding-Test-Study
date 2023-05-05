dx = (1, 0, -1, 0)  # 오 아 왼 위
dy = (0, 1, 0, -1)


def snail(board):
    x, y = 0, 0

    dist = N - 1
    direction = 0
    number = 1
    move_count = 0
    flag = True

    while True:
        move_count += 1
        print(move_count)
        for _ in range(dist):
            ny = y + dy[direction]
            nx = x + dx[direction]

            if (ny, nx) == (0, -1):
                return board

            number += 1
            board[ny][nx] = number

            y, x = ny, nx

        if move_count == 3:
            move_count = 0
            dist -= 1
            flag = False
        elif move_count == 2 and not flag:
            move_count = 0
            dist -= 1

        direction = (direction + 1) % 4


N = int(input())

for test_case in range(N):
    num = int(input())
    board = [[1] * num for _ in range(num)]

    nboard = snail(board)
    for row in nboard:
        print(row)
