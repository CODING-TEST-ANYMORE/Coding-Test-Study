'''선분중 가장 큰점의 인덱스와 가장 작은 점의 인덱스를 구한다.'''
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
dot = list(map(int, input().split()))

dot.sort() #점의 좌표 정렬

for i in range (m):
    a, b = map(int, input().split())
    
    start = 0
    end = n - 1
    while start <= end:# 가장 큰점 index
        mid = (start + end) // 2

        if b < dot[mid]:
            end = mid - 1
        else:
            start = mid + 1
    dot_max = end
    
    
    start = 0
    end = n-1
    
    while start <= end: #가장 작은점 index
        mid = (start + end) // 2

        if dot[mid] < a:
            start = mid + 1
        else:
            end = mid - 1
    dot_min = end +1
    
    print(dot_max-dot_min+1)
    