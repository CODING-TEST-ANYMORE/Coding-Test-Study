def solution(scoville, K):
    answer = 0
    while len(scoville) > 1:
        answer += 1

        first = scoville.pop(scoville.index(min(scoville)))
        second = scoville.pop(scoville.index(min(scoville)))

        new_scoville = first + (second * 2)

        scoville.append(new_scoville)  # 새로운 스코빌을 배열에 삽입해준다

        scoville.sort()  # 배열 오름차순 정렬

        if scoville[0] > K:
            break
    if scoville[0] < K:
        answer = -1

    return answer
