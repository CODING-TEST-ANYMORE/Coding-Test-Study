def solution(scoville, K):
    answer = 0
    while True:
        answer += 1
        flag = False

        first = scoville.pop(scoville.index(min(scoville)))
        second = scoville.pop(scoville.index(min(scoville)))

        new_scoville = first + (second * 2)

        scoville.append(new_scoville)  # 새로운 스코빌을 배열에 삽입해준다

        for i in scoville:
            if i < K:  # K보다 작은 스코빌이 있다면 for문을 나온다
                break
            else:
                flag = True  # 모든 스코빌이 K보다 크다면 통과

        if flag:
            break

    return answer
