T = int(input())

def resursive(n):       # 죽지도 않고 또 나온 재귀함수
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:               # 공식이 4부터 그전 3개의 값의 결괴를 더한 값
        return resursive(n-1) + resursive(n-2) + resursive(n-3)

for _ in range(T):      # T번
    n = int(input())
    print(resursive(n))