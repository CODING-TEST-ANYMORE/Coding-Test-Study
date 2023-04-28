from ast import literal_eval
from collections import deque

t = int(input())

for _ in range(t):
    r = 0
    flag = 0
    p = list(input())
    length = int(input())
    arr = input().strip()
    x = deque(arr[1:-1].split(','))
    if length == 0:
        x = deque()
    for c in p:
        if c == 'R':
            r += 1
        elif c == 'D':
            if len(x) == 0:
                print('error')
                flag = 1
                break
            else:
                if r % 2 == 0:
                    x.popleft()
                else:
                    x.pop()

    if flag == 1:
        continue
    else:
        if r % 2 == 0:
            print('[' + ",".join(x) + ']')
        else:
            x.reverse()
            print('[' + ",".join(x) + ']')
