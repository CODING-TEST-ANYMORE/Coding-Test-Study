import math
import sys

def check(mid, n):
    return mid * (mid + 1) // 2 <= n


def get_int():
    return int(sys.stdin.readline())

t = get_int()
for _ in range(t):
    n = int(sys.stdin.readline())
    s = 1
    e = int(math.sqrt(n) * 2)
    answer = 0
    while s <= e:
        mid = (s + e) // 2
        if check(mid, n):
            answer = mid
            s = mid + 1
        else:
            e = mid - 1
    print(answer)
