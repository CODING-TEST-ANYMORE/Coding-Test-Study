'''
도현이는 컴퓨터와 컴퓨터를 직접 연결하여야 한다
모든 컴퓨터가 연결이 되어있어야 한다
예를 들어 a 와 b 가 연결이 되어 있다는 말은 a에서 b로의 경로가 존재한다는 것을 의미
a에서 b를 연결하는 선이 있고, b와 c를 연결하는 선이 있으면 a와 c 는 연결되어 있다

그런데 이왕이면 컴퓨터를 연결하는 비용을 최소로 하고 싶다
각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 최소비용 출력
모든 컴퓨터를 연결할 수 없는 경우는 없다
'''

import sys
input = sys.stdin.readline

def find_parent(parent, x):
    # 루트노드를 찾을때까지 재귀
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N = int(input())
M = int(input())

# 부모테이블 초기화
parent = [0] * (N+1)

# 자기자신의 부모를 자기로 초기화
for i in range(1, N+1):
    parent[i] = i

edges = []
result = 0

for _ in range(M):
    a,b,c = map(int, input().split())
    edges.append((a,b,c))

edges = sorted(edges, key=lambda x:x[2])

# 간선을 하나씩 확인하여 사이클이 발생하지 않는 경우에만 집합에 포함
for e in edges:
    a,b,c = e
    if find_parent(parent, a) != find_parent(parent,b):
        union_parent(parent,a,b)
        result += c

print(result)


