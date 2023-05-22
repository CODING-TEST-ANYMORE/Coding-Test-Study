m,n = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(m)]
visited = [[-1] * n for _ in range(m)]    # 방문 여부 확인

def dfs(x, y):
    cnt = 0
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    if x == m-1 and y == n-1:             # 끝까지 도달하는 경우
        return 1
    
    if visited[x][y] != -1:               # 이미 더 낮다는걸 확인 한 경우
        return visited[x][y]

    for i in range(4):                     # 4방향 탐색
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < m and 0 <= ny < n:    # 맵 안에 있는 경우  
            if maps[x][y] > maps[nx][ny]:  # 갈 수 있는 경우
                cnt += dfs(nx, ny)                # 죽지 않고 돌아온 재귀함수
                
    visited[x][y] = cnt
    return visited[x][y]
    
print(dfs(0,0))