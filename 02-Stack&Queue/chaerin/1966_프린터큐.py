n = int(input())

for _ in range(n):
    n, m = list(map(int, input().split()))
    p = list(map(int, input().split()))
    count = 0
    idx = [0] * n
    idx[m] = 1
    while True:
        if p[0] == max(p):
            count += 1
            if idx[0] == 1:
                print(count)
                break
            else:
                s = p.pop(0)
                idx.pop(0)
        else:
            p.append(p.pop(0))
            idx.append(idx.pop(0))
