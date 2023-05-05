n,m,v = map(int,input().split())
visited = [0] * (n+1) 
maps = list([0]*(n+1) for i in range(n+1))

for i in range(m):
    a,b = map(int,input().split())
    maps[a][b] = maps[b][a] = 1             # 간선을 연결한 맵 만들기
    
def dfs(v):
    visited[v] = 1 
    print(v, end=' ')                        # 띄어쓰기가 있으므로 end = '' 사용
    for i in range(1, n+1):
        if visited[i] == 0 and maps[v][i] == 1: # 방문하지 않고 연결된 노드 일 경우
            dfs(i)                          # 재귀

def bfs(v):
    queue = [v] 
    visited[v] = 0 
    while queue:
        v = queue.pop(0) 
        print(v,end=' ') 
        for i in range(1 , n+1):
            if(visited[i] == 1 and maps[v][i] == 1):# 방문하지 않고 연결된 노드 일 경우
                queue.append(i)
                visited[i] = 0

dfs(v)
print()                                         # 사이에 엔터...역할..
bfs(v)