import sys

def dfs(n, m, iteration, check):

    if check[n] != 0:
        return check[n] - 1

    check[n] = iteration
   
    n = str(n)
    res = 0
    for i in n:
        res += pow(int(i), m)
   
    iteration += 1
    return dfs(res, m, iteration, check)

input = sys.stdin.readline
n, m = map(int, input().split())
check = [0] * 250000
iteration = 1

print(dfs(n, m, iteration, check))


