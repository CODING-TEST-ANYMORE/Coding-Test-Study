def solution(today, terms, privacies):
    answer = []
    terms_d = {}
    
    today = 336 * int(today[:4]) + 28 * int(today[5:7]) + int(today[8:])
    
    for i in terms:
        alpha, month = i.split()
        terms_d[alpha] = int(month)
        
    for num ,j in enumerate(privacies, start = 1) :
        j = 336 * int(j[:4]) + 28 * int(j[5:7]) + int(j[8:10]) + (terms_d[j[11:]] * 28)
        if today >= j:
            answer.append(num)
    return answer # 결과