# 프로그래머스 JadenCase 문자열 만들기 https://school.programmers.co.kr/learn/courses/30/lessons/12951
def solution(s):
    answer = ''

    for i in s:
        if answer == '': # 첫 단어 시작
            answer = i.lower()
            answer = i[0].upper()
            continue
        if i == ' ': # 공백이면 바로 공백 적용
            answer += i
        else: # 현재는 공백이 아닐경우
            if answer[-1] == ' ': # 바로 전이 공백
                if i.isdigit():
                    answer += i # 숫자면 그대로 적용
                else:
                    answer += i.upper() # 영어일 경우 대문자
            else:
                answer += i.lower()

    return answer