import sys

n = int(sys.stdin.readline().strip())
map = {}

for i in range(n):
    str = sys.stdin.readline().strip().split('.')
    map[str[1]] = map.get(str[1], 0) + 1

key = sorted(map.keys())

for i in key:
    print(i, map[i])