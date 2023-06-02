from collections import deque

m,n,h = map(int, input().split())
q = deque([])
Maps = []

for x in range(h):
    boxs = [] # 박스 준비
    for y in range(n):
        box = list(map(int, input().split()))
        for z in range(m):
            if box[z] == 1:      # 익은 토마토 발견
                q.append([x,y,z])# 익은 토마토 위치 deque 에 저장
        boxs.append(box)
    Maps.append(boxs)

def bfs():
    cnt = -1
    dx = [0,0,1,-1] 
    dy = [1,-1,0,0]

    while q:
        cnt += 1
        for _ in range(len(q)):
            z,x,y = q.popleft() # 익은 토마토 주변 탐색

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < n and 0 <= ny < m and Maps[z][nx][ny] == 0 : # Z축은 그대로 nx와 ny 위치만 변경
                    Maps[z][nx][ny] = 1 # 익은 토마토로 변경
                    q.append([z,nx,ny])
            nz = z - 1

            if 0 <= nz < h and Maps[nz][x][y] == 0: # 아래층 nx, ny
                Maps[nz][x][y] = 1 
                q.append([nz, x,y])
            nz = z + 1

            if 0 <= nz < h and Maps[nz][x][y] == 0: # 위층 nx, ny
                Maps[nz][x][y] = 1
                q.append([nz, x,y])

    for z in range(h):
        for y in range(n):
            if 0 in Maps[z][y]: # 아직도 0이 있다면 -1
                return -1
    return cnt

print(bfs())