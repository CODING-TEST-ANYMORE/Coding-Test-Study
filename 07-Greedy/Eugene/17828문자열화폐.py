from collections import deque   # 스택은 시간초과 나와서 deque로 빠른... 변경

n,m = map(int, input().split()) #  count , num

answer = deque()

if n * 26 < m or n > m:
    print("!")
else:
    for i in range(n):
        left = n - i - 1;    # 적어도 A 한개씩은 들어가야함
        if m-left > 26:      # 남은 수기 26보다 큰 경우
            answer.appendleft("Z")
            m = m-26         # m은 Z값을 뺀 만큼
        else:
            answer.appendleft(chr(m-left + 64)) 
            m = m -(m-left)
            
    print("".join(answer))