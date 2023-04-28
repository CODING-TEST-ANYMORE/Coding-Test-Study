import heapq

def solution(scoville, K):
    cnt = 0
    heapq.heapify(scoville)
    while True:
        min_sco = heapq.heappop(scoville) # 제일 앞에 있는 값이 나옴
        if min_sco >= K: # 맨 앞 값이 K보다 클 경우 
            return cnt
        if len(scoville) <= 0:
            return -1
        sec_min = heapq.heappop(scoville)
        heapq.heappush(scoville, min_sco + sec_min * 2) # 특별한 방법으로 섞기
        cnt += 1