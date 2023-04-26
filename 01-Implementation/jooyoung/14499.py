N, M, x, y, K = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]  # 지도
direction = list(map(int, input().split()))  # 명령어

dice = [0] * 6

dx = (0, 0, 0, -1, 1)  # 동(1) 서(2) 남(3) 북(4)
dy = (0, 1, -1, 0, 0)

for i in direction:
    nx = x + dx[i]
    ny = y + dy[i]

    if not 0 <= nx < N or not 0 <= ny < M:
        continue
    east, west, south, north, up, down = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]

    if i == 1:
        dice[0], dice[1], dice[4], dice[5] = down, up, east, west
    elif i == 2:
        dice[0], dice[1], dice[4], dice[5] = up, down, west, east
    elif i == 3:
        dice[2], dice[3], dice[4], dice[5] = down, up, south, north
    elif i == 4:
        dice[2], dice[3], dice[4], dice[5] = up, down, north, south

    if board[nx][ny] == 0:
        board[nx][ny] = dice[5] # 바닥

    else:
        dice[5] = board[nx][ny]
        board[nx][ny] = 0

    x, y = nx, ny
    print(dice[4])

''''
# 주사위 전개도 [1][1] == 바닥 [3][1] == 위
dice = [[0, 0, 0],
        [0, 0, 0],
        [0, 0, 0],
        [0, 0, 0]]

sx = sy = 1


# 주사위 전개도 숫자 재배치

def move_4():
    a = dice[0][1]
    dice[0][1] = dice[1][1]
    b = dice[3][1]
    dice[3][1] = a
    dice[2][1] = b


for i in direction:
    if i == 4:
        x += dx[i]  # 주사위 위치 조정
        y += dy[i]

        # 주사위 전개도 숫자 재배치
        dice[0][1] = dice[1][1]
        dice[3][1] = dice[0][1]
        dice[2][1] = dice[3][1]

        if board[x][y] != 0:
            dice[1][1] = board[x][y]  # 지도 위의 숫자가 0이 아니라면 그 숫자를 주사위 바닥에 복사
            board[x][y] = 0
        else:  # 지도 위 숫자가 0이라면
            board[x][y] = dice[1][1]
'''
