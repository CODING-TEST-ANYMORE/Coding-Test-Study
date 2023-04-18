dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]

t = int(input())

for _ in range(t):
    s = input()

    r, c, d, rmax, rmin, cmax, cmin = 0, 0, 0, 0, 0, 0, 0

    for i in s:
        if i == 'F':
            r += dir[d][0]
            c += dir[d][1]
        elif i == 'B':
            r -= dir[d][0]
            c -= dir[d][1]
        elif i == 'L':
            d = (d + 1) % 4
        elif i == 'R':
            d = 3 if d - 1 < 0 else d - 1

        rmax = max(rmax, r)
        rmin = min(rmin, r)
        cmax = max(cmax, c)
        cmin = min(cmin, c)

    print((rmax - rmin) * (cmax - cmin))