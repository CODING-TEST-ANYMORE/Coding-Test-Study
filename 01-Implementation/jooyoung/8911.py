dx = (0, -1, 0, 1)  # 상 좌 하 우
dy = (1, 0, -1, 0)

N = int(input())

for test_case in range(N):

    x = y = direction = 0  # 북 서 남 동
    mx = my = Mx = My = 0

    route = list(input().strip())

    for i in route:
        if i == "F":
            x += dx[direction]
            y += dy[direction]
        elif i == "B":
            x -= dx[direction]
            y -= dy[direction]
        elif i == "L":
            direction = (direction + 1) % 4
        elif i == "R":
            direction = (direction + 3) % 4

        mx = min(mx, x)
        my = min(my, y)
        Mx = max(Mx, x)
        My = max(My, y)

    answer = abs(My-my) * abs(Mx-mx)
    print(answer)
