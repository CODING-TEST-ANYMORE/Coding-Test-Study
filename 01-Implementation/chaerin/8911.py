def turtle():
    T = int(input())

    controls = []
    for _ in range(T):
        control = list(input())
        controls.append(control)

    for control in controls:
        x, y = 0, 0
        dx = [0, -1, 0, 1]
        dy = [1, 0, -1, 0]
        direction = 0
        trace = [(x, y)]
        for c in control:
            if c == 'F':
                x += dx[direction]
                y += dy[direction]
            elif c == 'B':
                x -= dx[direction]
                y -= dy[direction]
            elif c == 'L':
                if direction == 3:
                    direction = 0
                else:
                    direction += 1
            elif c == 'R':
                if direction == 0:
                    direction = 3
                else:
                    direction -= 1

            trace.append((x, y))

        width = max(trace, key=lambda pos_x: pos_x[0])[0] - min(trace, key=lambda pos_x: pos_x[0])[0]
        height = max(trace, key=lambda pos_x: pos_x[1])[1] - min(trace, key=lambda pos_x: pos_x[1])[1]
        print(width * height)


if __name__ == '__main__':
    turtle()
