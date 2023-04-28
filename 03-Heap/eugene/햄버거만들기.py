def solution(ingredient):
    answer = 0
    i = 0

    while i < len(ingredient)-3:    
        if ingredient[i:i+4] == [1,2,3,1]: # 순서가 1,2,3,1 일 경우에만 조립
            del (ingredient[i:i+4]) # 해당 인덱스는 삭제  
            i = i-3 # 위치 재 할당
            answer += 1                          
        i += 1                                   
    return answer