n = int(input())
per = list(map(int, input().split()))
find = False
for i in range(n - 1, 0, -1):
    if per[i - 1] < per[i]:  # 크기 비교 후
        for j in range(n - 1, 0, -1):
            if per[i - 1] < per[j]:
                per[i - 1], per[j] = per[j], per[i - 1]
                per = per[:i] + sorted(per[i:])
                find = True
                break
    if find:
        print(*per)  # 구글링으로 알게된! 리스트 앞에 *을 붙이면 안에 있는 숫자들을 1 2 3 4 로 출력 가능
        break
if not find:
    print(-1)
