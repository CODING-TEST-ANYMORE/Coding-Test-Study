'''큰수 배열을 만들어야하기에 앞에 작은수가 있는지 확인 
target 숫자를 정해서 이 숫자와 비교한다'''
import sys
input = sys.stdin.readline
n = int(input())
a = list(map(int, input().split()))

for i in range(n-1, 0, -1):
    if a[i-1]<a[i]:
        x = i-1
        break
else:
    print(-1)
    sys.exit()
 
for i in range(n-1, 0, -1):
    if a[x]<a[i]:
        a[x],a[i] = a[i],a[x]
        a = a[:x + 1] + sorted(a[x + 1:])
        print(*a)
        break