'''
deque에 대한 공부가 부족하여 구글링... 하였습니다 ;-;

'''
from collections import deque

t = int(input()) # 테스트 케이스 개수
for i in range(t):
    order = input().rstrip() # 수행할 명령어
    n = int(input())
    str = input().rstrip() # 덱에 들어갈 숫자들을 포함한 문자열
    s = ""  # 덱에 들어갈 숫자들을 임시로 저장할 문자열
    dq = deque()
    for i in range(len(str)):
        if str[i].isnumeric():
            s += str[i]
        else:
            if s != "":
                dq.append(int(s))
                s = ""
    if s != "":
        dq.append(int(s))

    reverse = False # 덱이 역순으로 되어 있는지 여부
    error = False
    for s in order:
        if s == "R":
            reverse = not reverse
        else: # 덱의 맨 앞 또는 맨 뒤에서 숫자를 삭제
            if not dq:
                print("error")
                error = True
                break
            if reverse:
                dq.pop()
            else:
                dq.popleft()

    # print 남발하며 일일히 찍어주는데 이거 말고 더 간단하고 쉬운 출력 방법이 있을지 고민했습니다.
    if not error:
        print("[", end="")
        if reverse: # 덱이 역순으로 되어 있으면 덱을 역순으로 출력
            for i in range(len(dq) - 1, -1, -1):
                if i == 0:
                    print(dq[i], end="")
                else:
                    print(dq[i], end=",")
        else: # 덱이 역순이 아니면 그대로 출력
            for i in range(len(dq)):
                if i == len(dq) - 1:
                    print(dq[i], end="")
                else:
                    print(dq[i], end=",")
        print("]")