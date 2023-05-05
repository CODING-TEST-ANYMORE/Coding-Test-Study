import heapq

def solution(scoville, K):
    answer = 0
    # 우선순위 큐 오름차순
    heapq.heapify(scoville)
    # 음식이 최소 2개 이상이고 제일 안매운 음식이 K보다 작을 때까지만 반복
    while len(scoville) > 1 and scoville[0] < K:
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        # 두 개의 음식을 섞어서 우선순위 큐에 추가
        heapq.heappush(scoville, first + (second * 2))
        # 조합 횟수 증가
        answer += 1
    # 모든 조합이 끝났을 때 우선순위 큐의 제일 맵지 않은 음식이 K보다 작다면 -1을 리턴
    if scoville[0] < K:
        return -1
    return answer