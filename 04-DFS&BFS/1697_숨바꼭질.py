from collections import deque

n,k = map(int, input().split())
Max = 100001
maps = [0] * 100001

que = deque()
que.append(n)

def bfs(n,k):
    while True:
        v = que.popleft()   # 현재 있는 위치
        move = [v-1, v+1, v*2] # 가는 방법
        if k == v:
            return maps[v] 
        for i in move:
            if 0 <= i < Max and not maps[i]: # 빙문 전
                maps[i] = maps[v] + 1 # 시간 경과
                que.append(i)
                
print(bfs(n,k))