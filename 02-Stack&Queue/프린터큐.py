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