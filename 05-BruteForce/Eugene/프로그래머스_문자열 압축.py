def solution(s):
    result = []
    for i in range(1, len(s)//2+2):
        answer = ''
        sam = s[:i]
        cnt = 1
        for j in range(i, len(s)+i, i):
            if sam == s[j:j+i]: # 만약 현재가 전과 같다면
                cnt += 1
            else:
                if cnt == 1:
                    answer += sam
                else:
                    answer += str(cnt) + sam
                sam = s[j:j+i]
                cnt = 1
        result.append(len(answer))

    return min(result)
