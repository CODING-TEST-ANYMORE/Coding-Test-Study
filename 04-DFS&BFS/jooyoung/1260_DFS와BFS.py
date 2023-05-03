import sys

input = sys.stdin.readline


def dfs(start, board, N):
    visited = []
    stack = [start]
    while stack:
        node = stack.pop()
        if node not in visited:
            visited.append(node)
            for i in range(N - 1, -1, -1):
                if board[node - 1][i] == 1:
                    stack.append(i + 1)

    return visited


N, M, V = map(int, input().split())  # 정점의 개수, 간선의 개수, 탐색 시작할 정점의 번호

visit = [[0 for j in range(N)] for i in range(N)]  # 정점 간의 연결 상태를 확인하기 위함

for _ in range(M):  # 간선의 개수만큼 간선 정보를 받아와야 한다
    i, j = map(int, input().split())
    visit[i - 1][j - 1] = 1
    visit[j - 1][i - 1] = 1

print(dfs(V, visit, N))
