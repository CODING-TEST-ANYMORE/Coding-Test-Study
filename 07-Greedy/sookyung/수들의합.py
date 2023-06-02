'''
1부터 차례대로 더하다가 s보다 커지면 그때 n 출력

s 값과 동일한 경우 까지 찾아주려고 했는데 문제 요구사항이
그것까지 찾으라는 건 아닌 것 같아서 s 넘어가는 순간에 breaK해서 
그 숫자를 출력하도록 했습니다.'''


s = int(input())

total=0
n = 0

while 1:
    n += 1
    total += n
    if total > s:
        break


print(n-1)