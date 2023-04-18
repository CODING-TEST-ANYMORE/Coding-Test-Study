h, w = map(int, input().split())
c = [list(input().strip()) for i in range(h)]
ans = [[-1] * w for i in range(h)]

for i in range(h):
    for j in range(w):
        if c[i][j] == 'c':
            ans[i][j] = 0
        elif j > 0 and ans[i][j-1] >= 0:
            ans[i][j] = ans[i][j-1] + 1

for i in range(h):
    for j in range(w):
        print(ans[i][j], end=' ')
    print()