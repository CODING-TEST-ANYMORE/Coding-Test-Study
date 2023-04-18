import sys

n, m, y, x, k = map(int, sys.stdin.readline().split())
_map = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
moves = list(map(int, sys.stdin.readline().split()))
dice = [0] * 6  # 주사위의 현재 각면에 있는 숫자를 저장하는 리스트
# 각 방향에 따른 y, x의 변화량
dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]

for move in moves:
    move_y = y + dy[move - 1]
    move_x = x + dx[move - 1]
    if move_y < 0 or move_x < 0 or move_y >= n or move_x >= m:
        continue
    y, x = move_y, move_x
    if move == 1:  # 동쪽
        dice[0], dice[5], dice[2], dice[4] = dice[5], dice[2], dice[4], dice[0]
    elif move == 2:  # 서쪽
        dice[0], dice[4], dice[2], dice[5] = dice[4], dice[2], dice[5], dice[0]
    elif move == 3:  # 북쪽
        dice[0], dice[1], dice[2], dice[3] = dice[1], dice[2], dice[3], dice[0]
    else:  # 남쪽
        dice[0], dice[3], dice[2], dice[1] = dice[3], dice[2], dice[1], dice[0]
    if _map[y][x] == 0:
        _map[y][x] = dice[0]
    else:
        dice[0] = _map[y][x]
        _map[y][x] = 0
    print(dice[2])