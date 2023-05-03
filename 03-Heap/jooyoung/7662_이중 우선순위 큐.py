import sys
import heapq

input = sys.stdin.readline

T = int(input())  # 테스트 케이스

for test_case in range(T):
    times = int(input())  # 입력할 [명령어 숫자] 갯수
    max_heap = []
    min_heap = []
    visited = [False] * times

    for i in range(times):  # times 만큼 I 34, D 1 등의 형식의 명령이 입력된다
        do_num = input().rsplit()

        if do_num[0] == 'I':
            heapq.heappush(min_heap, (int(do_num[1]), i))
            heapq.heappush(max_heap, (-int(do_num[1]), i))
            visited[i] = True  # True이면 어떤 힙에서도 아직 삭제되지 않은 상태

        elif do_num[0] == 'D':
            if do_num[1] == '-1':  # 힙 내 최솟값을 삭제해준다.
                # 이때 i 값을 기준으로 해당 노드가 다른힙에서 삭제된 노드인가를 먼저 확인해준다
                # min_heap이 비어있지 않고 다른 힙(max_heap)에서 삭제되었다면
                while min_heap and not visited[min_heap[0][1]]:  # min_heap[0][1] == i
                    heapq.heappop(min_heap)  # min_heap에서도 제거해준다
                if min_heap:  # min_heap이 비어있지 않다면
                    visited[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
            elif do_num[1] == '1':
                # 위에서 min_heap에 걸려 삭제되었지만 max_heap 에는 아직 남아있다고 저장되어있기 때문에
                # while문을 통해 두 힙을 동기화시켜주는 것이다.
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heapq.heappop(max_heap)

    # 명령 처리를 마무리 후 두 힙을 각각 동기화 시켜준다
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)

    if min_heap and max_heap:
        print(-max_heap[0][0], min_heap[0][0])
    else:
        print("EMPTY")
