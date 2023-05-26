import sys
input = sys.stdin.readline

n= int(input())
d =[0]*(n+1)
for i in range(1,n+1):
    t, p = map(int, input().split())
    d[i] = max(d[i-1], d[i])
    if t+i<=n+1:
        d[i+t-1] = max(d[i-1]+p, d[i+t-1])
print(d[-1])    