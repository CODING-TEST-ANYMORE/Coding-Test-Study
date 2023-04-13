# 프로그래머스 신고결과 받기 https://school.programmers.co.kr/learn/courses/30/lessons/92334
def solution(id_list, report, k):
    result = [0] * len(id_list)
    id_dict = {}
    sam_dict = {}
    
    for i in id_list:
        id_dict[i] = 0 # id_list 딕셔너리
        sam_dict[i] = []
    
    for j in set(report):
        j = j.split() 
        id_dict[j[1]] += 1 # 신고 당한 횟수 세기
        sam_dict[j[0]].append(j[1])
    
    for x,y in id_dict.items():
        if y >= k: # 신고 횟수가 k개 이상인 경우
            for i,j in sam_dict.items():
                if x in j:
                    result[id_list.index(i)] += 1 
                    # k개 이상인 원소를 가진 id_list +1  
    return result

    

