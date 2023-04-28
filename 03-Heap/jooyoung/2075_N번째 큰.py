N = int(input())  # N*N

board = list(list(map(int, input().split())) for _ in range(N))  # 숫자 채우기

heap_list = list(dict() for _ in range(N))  # N개 만큼의 힙을 만들어준다. 힙은 딕셔너리로 구현하였다

for i in range(N):
    for j in range(1, N + 1):
        max_node = board[i].pop(board[i].index(max(board[i])))  # 최댓값을 pop 해주고 힙딕셔너리에 넣어준다
        heap_list[i][j] = max_node

parent = 1  # 부모노드
kid = parent * 2
# right = (parent * 2) - 1
while True:
    find_N = [heap_list[N - 1][parent]]  # board 에서 가장 큰 수 넣어주기
    if heap_list[N - 1][kid] > heap_list[N - 2][parent]:
        find_N.append(heap_list[N - 1][2])
        kid = (parent * 2) + 1
    else:
        N -= 1
