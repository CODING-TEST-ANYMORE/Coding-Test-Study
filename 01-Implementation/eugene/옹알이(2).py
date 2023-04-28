# 프로그래머스 옹알이(2) https://school.programmers.co.kr/learn/courses/30/lessons/133499
def solution(babbling):
    answer = 0
    can = ["aya","ye","woo","ma"]   
    
    for i in babbling:                  
        for j in can:            
            if j+j not in i: # 연속한 발음은 못하기 때문     
                i = i.replace(j,' ')  # j를 ''로 변경
        if i.strip()=='':  # 모두 "" 즉, 모두 가능한 말일 경우     
            answer+=1       
            
    return answer