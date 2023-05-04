import heapq
import sys
input = sys.stdin.readline

x= int(input())
h = []
for i in range(x):
    n= int(input())
    if n == 0:
        if len(h) != 0:
            print(-heapq.heappop(h))
        else:
            print(0)
    else:
        heapq.heappush(h, -n)
     