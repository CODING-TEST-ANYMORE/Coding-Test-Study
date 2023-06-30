import sys


# 부모 노드 찾기
def find_parent(parent, x):
    # 루트노드를 찾을때까지 재귀
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

#집합 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


v, e = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(e)]

graph.sort(key=lambda x: x[2])  # 간선들을 가중치 기준으로 정렬

parent = [i for i in range(v + 1)] # 부모를 자기로 초기화
answer = 0

# 반복문을 통해 간선들의 두 정점을 확인
for s, e, w in graph:
    # 부모 노드가 같지 않다면
    if find_parent(s) != find_parent(e):
        union_parent(parnet, s, e)  # 두 노드를 합친다.
        answer += w

print(answer)
