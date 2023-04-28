# def turn(direction, dice):
#     n1, n2, n3, n4, n5, n6 = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]
#     if direction == 1:
#         return [n1, n3, n5, n2, n4, n6]
#     elif direction == 2:
#         return [n1, n4, n2, n5, n3, n6]
#     elif direction == 3:
#         return [n5, n1, n3, n4, n6, n2]
#     elif direction == 4:
#         return [n2, n6, n3, n4, n1, n5]
def turn(dir, dice):
    a, b, c, d, e, f = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]
    if dir == 1:  # 동
        return [d, b, a, f, e, c]

    elif dir == 2:  # 서
        return [c, b, f, a, e, d]

    elif dir == 3:  # 북
        return [e, a, c, d, f, b]

    else:
        return [b, f, c, d, a, e]


n, m, x, y, k = map(int, input().split())

board = []
# 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
D = [0, 0, 0, 0, 0, 0]

for i in range(n):
    board.append(list(map(int, input().split())))

direction = list(map(int, input().split()))

nx, ny = x, y
for i in direction:
    nx += dx[i - 1]
    ny += dy[i - 1]

    if nx < 0 or nx >= n or ny < 0 or ny >= m:
        nx -= dx[i - 1]
        ny -= dy[i - 1]
        continue

    D = turn(i, D)

    if board[nx][ny] == 0:
        board[nx][ny] = D[5]
    else:
        D[5] = board[nx][ny]
        board[nx][ny] = 0

    print(D[0])
