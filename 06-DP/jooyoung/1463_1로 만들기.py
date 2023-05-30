N = int(input())

visit = [0] * 1000000
q = [N]
new_num = []
while q:
    start = q.pop(0)

    if start % 3 == 0:
        new_num.append(start // 3)
    if start % 2 == 0:
        new_num.append(start // 2)
    if True:
        new_num.append(start - 1)

    for num in new_num:
        if num != 1 and not visit[num]:
            q.append(num)
            visit[num] = visit[start] + 1
        if num == 1:
            visit[num] = visit[start] + 1
            print(visit[num])
            exit()
    new_num.clear()
