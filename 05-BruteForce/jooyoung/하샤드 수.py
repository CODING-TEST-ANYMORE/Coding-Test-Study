def solution(x):
    answer = True
    x_ = x
    lenOfx = len(str(x))
    num = 0
    for i in range(len(str(x))):
        lenOfx = len(str(x))
        if lenOfx == 5:
            num += x // 10000
            x %= 10000
        elif lenOfx == 4:
            num += x // 1000
            x %= 1000
        elif lenOfx == 3:
            num += x // 100
            x %= 100
        elif lenOfx == 2:
            num += x // 10
            x %= 10
        elif lenOfx == 1:
            num += x
            break

    if x_ % num != 0:
        answer = False
    return answer