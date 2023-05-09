'''
처음의 아기상어의 크기는 2
아기상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고
나머지 칸은 모두 지나갈 수 있다

아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.

따라서 크기가 같은 물고기는 먹을 수 없지만 그 칸을 지나갈 수 는 있다

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1증가한다.

0: 빈칸 || 1,2,3,4,5,6: 칸에 있는 물고기의 크기 || 9: 아기 상어의 위치
1. 거리가 가장 가까운 물고기 먹으러 간다. 이때 거리는 칸 수이다
2. 다음 우선순위는 가장 위에 있는 물고기 , 그 다음으로는 가장 왼쪽에 있는 물고기이다
'''

N = int(input())
shark_x, shark_y = 0, 0
size = 2
dx = (0, 0, 1, -1)  # 상 하 우 좌
dy = (1, -1, 0, 0)
cnt = 0  # 물고기를 먹은 횟수 측정
time = 0
board = [list(map(int, input().split())) for _ in range(N)]  # 물고기의 위치와 크기

# 아기상어 위치
for i in range(N):
    for j in range(N):
        if board[i][j] == 9:
            x = i
            y = j


def bfs(x, y, shark_size):
    dist = [[0] * N for _ in range(N)]
    visit = [[0] * N for _ in range(N)]

    result_arr = []
    queue = []

    queue.append((x, y))  # 아기상어의 위치, 물고기 위치를 저장
    visit[x][y] = 1  # 아기상어가 방문한 곳으로 표시

    while queue:  # 저장되어 있는 물고기들의 거리와 크기 확인
        now_x, now_y = queue.pop(0)  # 큐의 첫번째 요소

        for i in range(4):  # 상하좌우 확인
            nx = now_x + dx[i]
            ny = now_y + dy[i]

            # board 의 범위를 벗어나지 않았고 아직 방문한 적이 없다면
            if 0 <= nx < N and 0 <= ny < N and not visit[nx][ny]:
                if board[nx][ny] <= shark_size:  # 아기 상어보다 물고기가 작거나 같다면 -> 지나치거나 먹을 수 있듬
                    queue.append((nx, ny))  # 물고기의 위치를 저장
                    visit[nx][ny] = 1  # 아기상어가 방문했다고 표시
                    dist[nx][ny] = dist[now_x][now_y] + 1  # 아기상어로 부터의 거리를 계산해준다

                    # 먹을 수 있는 물고기라면
                    if board[nx][ny] < shark_size and board[nx][ny] != 0:
                        result_arr.append((nx, ny, dist[nx][ny]))  # 물고기의 위치와 거리

    # 물고기의 거리가 작은 것 부터, 위, 왼쪽 순으로 우선순위를 정해준다
    return sorted(result_arr, key=lambda x: (-x[2], -x[0], -x[1]))  # dist,x,y


while True:
    baby_shark = bfs(x, y, size)

    # 먹을 수 있는 물고기가 없음
    if len(baby_shark) == 0:
        break

    xx, yy, dist = baby_shark.pop()

    time += dist  # 칸 수 == 시간
    # 아기상어가 물고기를 먹으면 물고기는 사라지고 빈칸(0)이 된다
    board[x][y] = 0
    board[xx][yy] = 0

    cnt += 1

    if cnt == size:  # 물고기를 먹은 횟수와 아기상어의 크기가 동일하다면
        size += 1
        cnt = 0

print(time)
