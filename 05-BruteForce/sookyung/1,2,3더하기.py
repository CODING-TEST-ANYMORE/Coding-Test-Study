import sys
input = sys.stdin.readline

l = [0] * 11
l[1] = 1
l[2] = 2
l[3] = 4

''' 현재의 수가 나오는. 각각의 이전 조합의 경우의 수를 더하면 된다 '''
for i in range(4, 11):
    l[i]=l[i-3]+l[i-2]+l[i-1]

n = int(input())
for _ in range(n):
    print(l[int(input())])