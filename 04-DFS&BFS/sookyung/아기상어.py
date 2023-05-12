''' 
풀다가 ㅜ bfs 구현 부분을 구글링 했습니다..

자기보다 크기가 큰 물고기 : 못먹음, 지나가기 가능
크기 같은 물고기 : 못먹음, 지나가기 가능
크기 작은 물고기 : 먹음. 지나가기 가능
아기상어 현재 크기만큼 물고기 (개수) 먹으면 아기상어 크기+1

더 이상 먹을 물고기 없다 = 엄마 상어에게 Help 요청하고 종료
고기 1마리 남음 : 무조건 그물고기 먹으러
고기 2마리 이상 : 가장 가까운 물고기 먹으러간다.
가장 가까운 물고기 2마리 이상이면 x 작은순. 그게 또 2마리 이상이면 y작은 순
'''


import sys
from collections import deque
input = sys.stdin.readline

#아기상어 위치
shark_x, shark_y = 0,0 
#아기상어 정보
shark_size = 2
eat_cnt = 0

#물고기?
fish_cnt = 0
fish_pos = []
time = 0

dx = (0,0,1,-1)
dy = (1,-1,0,0)

n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]

def bfs(shark_x,shark_y):
    q = deque([(shark_x,shark_y,0)])
    dist_list = []
    visited = [[0]*n for _ in range(n)]
    visited[shark_x][shark_y] = 1
    min_dist = int(1e9)
    while q:
        x,y,dist = q.popleft()
        for i in range(4):
            xx = dx[i]+x
            yy = dy[i]+y
            if 0<=xx<n and 0<=yy<n and not visited[xx][yy]:
                if board[xx][yy] <= shark_size: #아기상어 크기보다 작은 곳만
                    visited[xx][yy] = True
                    if 0<board[xx][yy]<shark_size:
                        min_dist = dist
                        dist_list.append((dist+1,xx,yy))
                    if dist+1 <= min_dist:
                        q.append((xx,yy,dist+1))
    if dist_list:
        dist_list.sort()
        return dist_list[0]
    else:
        return False

for i in range(n):
    for j in range(n):
        if 0 < board[i][j] <=6: #물고기 크기 checK
            fish_cnt +=1
            fish_pos.append((i,j))
            
        elif board[i][j] == 9: # 아기상어 위치
            shark_x, shark_y = i,j
board[shark_x][shark_y]=0



while fish_cnt : #물고기가 남아있지 않을때 까지
    result = bfs(shark_x,shark_y)
    if not result:
        break
    shark_x,shark_y = result[1],result[2]
    time +=result[0]
    eat_cnt+=1
    fish_cnt-=1
    if shark_size == eat_cnt:
        shark_size +=1
        eat_cnt =0
    board[shark_x][shark_y] = 0

print(time)