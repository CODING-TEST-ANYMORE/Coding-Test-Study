import sys
input = sys.stdin.readline
n, x = map(int, input().split())
result = ""
# n이 x 보다 큰 경우(모두 A일때 합이 x보다 큰 경우), n*26 보다 x가 작은 경우(모두 Z일때의 합이 x 보다 작은 경우)
if n > x or n*26 < x:
    print("!")
    
else: 
    array = ["A"]*n
    x = x - n #x 값중 n만큼 채웠으니 빼준다.
    i = len(array) - 1
    while x>0: #x가 음수가 되기 전까지 반복
        if x>=25:
            array[i] = "Z" # array 맨 마지막을 Z로 바꿔줌
            i=i-1
            x=x-25 #이제 Z가 들어갔으니 25만큼 뺴준다.(A -> Z이므로 26이 아니라 25)
        else:
            array[i] = chr(x+65) #아스키 코드로 계산
            break
    
    print("".join(array))   
    
    # 이렇게 하니까 시간 초과가 발생하네요!
    # for j in range(n):
    #     result = result+array[j]        
    # print(result)
    