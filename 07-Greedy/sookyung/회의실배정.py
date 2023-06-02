'''회의가 끝나는 시간 순대로 오름 차순 해야한다'''

import sys
input = sys.stdin.readline
n= int(input())

time = [[0]*2 for _ in range(n)]

for i  in range(n):
    s, e = map(int, input().split())
    time[i][0] = s
    time[i][1] = e
    
time.sort(key = lambda x: (x[1], x[0]))
end = time[0][1]

count=1
for i in range(1,n):
    if time[i][0] >= end:
       count = count +1
       end =time[i][1] 
print(count)