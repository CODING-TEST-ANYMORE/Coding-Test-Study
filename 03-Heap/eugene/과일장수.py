def solution(k, m, score):
    return sum(sorted(score)[len(score)%m : : m]) * m # 최저 사과의 점수를 [len(score)%m ::m] 으로 골라준다.
    # 어쩌피 사과 개수는 m개이기 때문에 sum후 m을 곱해주면 된다.