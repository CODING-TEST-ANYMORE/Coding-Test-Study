'''
하나의 노드가 얼마나 깊이까지 가는지 모두 확인해서 최단시간을 찾으려면 모든 경로를 다 탐색해야하므로 비효율적이다
즉, BFS 으로 동일 시간내에서(동일 깊이 내에서) 가장 먼저 도착하는 경우가 생겼을 때가 최적시간이다
'''


def bfs(start):
    q = [start]
    while q:
        start = q.pop(0)  # 큐의 첫번째 원소
        if start == K:  # 위치가 같다면 return
            return visit[start]
        for i in (start * 2, start - 1, start + 1):
            if 0 <= i < MAX and not visit[i]:  # visit[i] == 0 : False
                q.append(i)
                visit[i] = visit[start] + 1


MAX = 100001
visit = [0] * MAX
N, K = map(int, input().split())  # 수빈이의 위치, 동생의 위치
print(bfs(N))
