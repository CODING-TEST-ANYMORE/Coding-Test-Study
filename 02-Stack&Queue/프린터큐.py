'''
Queue의 가장 앞에 있는 문서의 '중요도'를 확인
Queue 다른 곳에 하나라도 '중요도'가 더 높은 것이 있다면 현재 가장 앞에 있는 문서를 Queue의 맨뒤로 보낸다.
가장 앞에 있는 문서의 '중요도'가 가장 높으면 바로 출력.

PriorityQueue에서 맨 앞의 값이 우선순위가 가장 높은 값이므로
이를 이용하여 코드를 작성하였습니다.'''

import queue

testn = int(input())

for i in range(testn):
    count = 0
    n, m = map(int, input().split())
    
    pq = queue.PriorityQueue() # 우선순위 큐
    q = queue.Queue() # 일반적인 큐
    
    for j, importance in enumerate(map(int, input().split())):
        q.put((j, importance))
        pq.put((-importance, j)) # 내림차순 정렬

    while not q.empty():
        location, value = q.get()
        
        if -pq.queue[0][0] == value: # 가장 높은 우선순위 확인
            pq.get()
            count += 1
            if m == location:
                print(count)
                break
        else:
            q.put((location, value))