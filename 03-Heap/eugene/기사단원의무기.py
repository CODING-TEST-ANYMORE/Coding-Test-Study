def solution(number, limit, power):
    result = 0

    for j in range(1, number+1):
        mogi = 0
        for i in range(1, int(j**0.5) + 1):  # 제곱근 만큼 반복
            if j % i == 0:
                mogi += 1
                if i != j/i:
                    mogi += 1
        if mogi > limit:
            mogi = power
        result = result + mogi

    return result
