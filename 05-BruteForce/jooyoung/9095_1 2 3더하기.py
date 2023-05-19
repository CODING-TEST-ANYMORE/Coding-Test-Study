'''
(1)1 = 1
(2)2 = 1 + 1
  = 2
(3)3 = 1 + 1 + 1
  = 1 + 2
  = 2 + 1
  = 3
4 의 경우 1 + 3, 2 + 2, 3 + 1 로 나누어서 생각
'''

N = int(input())
answer = []
for i in range(N):
    num = int(input())  # 숫자 입력받기
    num_list = [0] * (num + 1)  # 입력받은 수보다 1개 더
    if num == 1:  # 1,2,3, 인 경우는 그냥 단순 저장
        answer.append(1)
    elif num == 2:
        answer.append(2)
    elif num == 3:
        answer.append(4)
    else:
        num_list[1] = 1
        num_list[2] = 2
        num_list[3] = 4
        for j in range(4, num + 1):
            num_list[j] = num_list[j - 1] + num_list[j - 2] + num_list[j - 3]
        answer.append(num_list[num])
print(*answer)
