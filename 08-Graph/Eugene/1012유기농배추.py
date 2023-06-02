import sys
sys.setrecursionlimit(10**7) # Recursion Error 재귀 한도 늘리기..

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

t = int(input())

def dfs(x, y, cnt):
    visited[x][y] = cnt # 방문

    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < n and 0 <= ny < m: # 벗어나지 않는 경우
            if maps[nx][ny] == 1 and visited[nx][ny] == -1:
                dfs(nx, ny, cnt) # 재귀함수

for _ in range(t):
    m, n, k = map(int, input().split())
    maps = [[0] * m for _ in range(n)]
    visited = [[-1] * m for _ in range(n)]
    cnt = 0

    for _ in range(k): # k 줄에 주어진다
        i, j = map(int, input().split())  # 배추의 위치 X,Y
        maps[j][i] = 1 # 배추의 위치 1로 변경

    for i in range(n):
        for j in range(m):
            if maps[i][j] == 1 and visited[i][j] == -1: # 방문하지 않았고, 배추가 있을 경우
                cnt += 1
                dfs(i, j, cnt)

    print(cnt)