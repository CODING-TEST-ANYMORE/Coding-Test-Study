N, M = map(int, input().split())
original = []
count = []

for _ in range(N):
    original.append(input())

for a in range(N - 7):
    for b in range(M - 7):
        count_b = 0
        count_w = 0
        for i in range(a, a + 8):
            for j in range(b, b + 8):
                # 체스판의 시작점 a,b를 기준으로 i,j의 합이 짝수이면 시작점과 같은색, 홀수이면 다른 색이어야 한다.
                if (i + j) % 2 == 0:
                    if original[i][j] != 'W':
                        count_b += 1
                    if original[i][j] != 'B':
                        count_w += 1
                else:
                    if original[i][j] != 'B':
                        count_b += 1
                    if original[i][j] != 'W':
                        count_w += 1
        # 검정색이든 하얀색이든 더 개수가 작은 쪽을 변경하면 되므로 min()을 사용
        count.append(min(count_b, count_w))

print(min(count))
