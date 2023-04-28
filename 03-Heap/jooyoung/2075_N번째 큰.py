N = int(input())  # N*N
# 리스트를 받음과 동시에 내림차순 정렬을 해준다. 이와 동시에 slicing으로 N개만 저장한다.
board = []
for _ in range(N):  # N번 동안 리스트를 받는다
    board += list(map(int, input().split()))
    board = sorted(board, reverse=True)[:N]  # 내림차순으로 정렬해주고 5개까지만 저장한다.

print(board[-1])
