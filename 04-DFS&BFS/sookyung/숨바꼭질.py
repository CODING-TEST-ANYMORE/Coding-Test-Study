import sys
input = sys.stdin.readline

from collections import deque

n,m=map(int,input().split())

# 움직일수 있는 최대 좌표 100000
MAX=100000
visited=[0]*(MAX+1)

def bfs():
    q=deque()
    # 출발위치 n 큐에 삽입.
    q.append(n)
  
    while q:
        x=q.popleft()
        # 위치가 동생의 위치와 같다면 breaK
        if x==m:
            print(visited[x])
            break

        for i in (x-1,x+1,x*2):
            if 0<=i<=MAX and visited[i]==0:
                visited[i]=visited[x]+1
                q.append(i)

bfs()