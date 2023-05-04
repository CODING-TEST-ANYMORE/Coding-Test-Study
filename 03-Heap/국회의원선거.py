import sys, heapq
input = sys.stdin.readline

n = int(input())
m = int(input())
peo = []

for _ in range(n - 1):
    num = int(input())
    heapq.heappush(peo, (-num, num))

cnt = 0
while peo:
    num = heapq.heappop(peo)[1]
    if num >= m:
        num -= 1
        m += 1
        cnt += 1
        heapq.heappush(peo, (-num, num))

print(cnt)