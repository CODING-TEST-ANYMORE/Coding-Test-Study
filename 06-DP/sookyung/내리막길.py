'''
자꾸 시간초과가 발생하여 구글링 했습니다 ㅜㅜ
dfs와 dp를 사용하여 문제를 풀었습니다.
'''

import sys
sys.setrecursionlimit(200000)
input = sys.stdin.readline
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(m)]
d = [[-1 for _ in range(n)] for _ in range(m)]

def dfs(x, y):
    if x == m - 1 and y == n - 1: # 목적지에 도착했는지, 도착했다면 return 1 
        return 1
    if d[x][y] == -1: # 탐색하지 않은 곳이라면 탐색
        d[x][y] = 0 
        for i in range(4): #상하좌우 탐색
            nx = x + dx[i]
            ny = y + dy[i]
            # 현제 높이보다 낮은 높이라면
            if 0 <= nx < m and 0 <= ny < n:
                if graph[x][y] > graph[nx][ny]:
                    d[x][y] += dfs(nx, ny) 
    return d[x][y]

print(dfs(0,0))