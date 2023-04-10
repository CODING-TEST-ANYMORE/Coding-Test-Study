T = int(input())
testcases = [input() for _ in range(T)]

dx = [0, -1, 0, 1]   # 상좌하우
dy = [1, 0, -1, 0]

for i in testcases:
    list_x = [0]     # 좌표를 저장할 리스트
    list_y = [0]
    direction = 0    # 방향을 저장할 리스트
    x,y = 0,0        # 현재 좌표
    for j in i:
        if j == 'L':
            if direction == 3: # 인덱스를 넘을 경우 초기화
                direction = 0
            else:
                direction += 1
        elif j == 'R':
            if direction == 0:
                direction = 3
            else:
                direction -= 1
        elif j == 'F':
            x += dx[direction] # 해당 방향으로 이동
            y += dy[direction]
            list_x.append(x)
            list_y.append(y)
        else:
            x -= dx[direction]
            y -= dy[direction]
            list_x.append(x)
            list_y.append(y)
    print(abs(max(list_x)-min(list_x)) * abs(max(list_y)-min(list_y)))
    # 최소 결과 넓이, abs를 사용해 절댓값으로 출력