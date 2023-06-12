''''
보관 후 하루가 지나면,
익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은
익은 토마토의 영향을 받아 익게 된다.
'''

M, N, H = map(int, input().split())  # 세로, 가로, 상자 수
box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]
visited = [[[False] * M for _ in range(N)] for _ in range(H)]
q = []
answer = 0


def bfs():
    while q:
        x, y, z = q.pop(0) # 익은 토마토의 위치
        for o in range(6):  # 6개의 방향을 확인해준다
            nx = x + dx[o]
            ny = y + dy[o]
            nz = z + dz[o]

            if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M:
                continue

            if box[nx][ny][nz] == 0 and not visited[nx][ny][nz]:
                q.append((nx, ny, nz))  # 익지 않은 토마토
                box[nx][ny][nz] = box[x][y][z] + 1  # 익은 토마토로 변경
                visited[nx][ny][nz] = True  # 방문 표시


dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 1 and not visited[i][j][k] :
                q.append((i, j, k))  # 배열을 도는 동안 익은 토마토가 있고 방문 한적이 없다면 큐에 삽입
                visited[i][j][k] = True

bfs()

for i in box:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit(0)
        answer = max(answer, max(j))

print(answer - 1)
