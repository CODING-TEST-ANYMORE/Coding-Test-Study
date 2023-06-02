from collections import Counter
def solution(x,y):
    x = (int(i) for i in x )
    y = (int(i) for i in y )
    result = sorted(list((Counter(x)&Counter(y)).elements()), reverse=True)
    if result == []:
        return '-1'
    if max(result) == 0:
        return '0'
    return ''.join((str(i) for i in result)) # 결과