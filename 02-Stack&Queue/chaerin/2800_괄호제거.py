s = input()
from itertools import combinations

# 괄호을 담기위한 stack
n = []
# 괄호의 index를 담기 위한 stack
m = []
# 괄호 세트의 index를 담기 위한 array [(0,6),(3,5)]
index = []
# 결과 수식을 sort하기 전에 담는 set, set을 사용하지 않으면 틀림
result = set()
for idx in range(len(s)):
    i = s[idx]
    # 여는 괄호를 만나면 stack에 저장
    if i == '(':
        n.append(i)
        m.append(idx)
    # 닫는 괄호를 만나면 stack에 가장 마지막에 담긴게 여는 괄호일 때 index 배열에 추가
    elif i == ')':
        if n[-1] == '(':
            n.pop()
            index.append((m.pop(), idx))

# 괄호 세트를 담은 index 배열에서 가능한 경우의 수를 모두 계산
for j in range(1, len(index) + 1):
    # n*(n-1)/2 의 경우의 수가 나옴
    c = combinations(index, j)
    for k in c:
        answer = list(s)
        for i in k:
            # 괄호 지우기
            answer[i[0]] = ''
            answer[i[1]] = ''
        result.add(''.join(answer))

# sort
for a in sorted(result):
    print(a)
