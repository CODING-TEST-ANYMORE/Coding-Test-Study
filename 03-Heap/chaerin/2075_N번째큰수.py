import heapq
import sys

input = sys.stdin.readline
n = int(input())
q = []
for i in range(n):
    nums = list(map(int, input().split()))
    if not q:
        for num in nums:
            heapq.heappush(q, num)
    else:
        for num in nums:
            if q[0] < num:
                heapq.heappush(q, num)
                heapq.heappop(q)

print(q[0])
