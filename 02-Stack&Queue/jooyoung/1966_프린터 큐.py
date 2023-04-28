T = int(input())  # testcase
count = 0  # 출력

for test_case in range(T):
    N, M = map(int, input().split())  # 문서 개수, 궁금한 문자 현재 위치

    q = list(map(int, input().split()))  # 문서의 중요도를 배열로 나타냄
    idx = list(range(len(q)))  # 인덱스 배열

    idx[M] = 'M'

    while True:
        if q[0] == max(q):  # 첫 번째 문서가 가장 큰 중요도라면
            count += 1
            if idx[0] == 'M':  # 만약 첫번째 문서가 궁금했던 문서라면
                print(count)
                break
            else:  # 첫번째 문서가 궁금했던 문서는 아니라면 큐와 인덱스 큐에서 삭제해준다
                q.pop(0)
                idx.pop(0)

        else:  # 첫 번째 문서가 가장 큰 중요도가 아니라면
            q.append(q.pop(0))  # 큐의 가장 뒤에 다시 삽입해준다
            idx.append(idx.pop(0))
