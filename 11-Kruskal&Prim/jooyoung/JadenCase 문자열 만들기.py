def solution(s):
    answer = ''
    s = s.title()
    for i in range(len(s)):
        if s[i-1].isdigit() and s[i].isupper():
            answer += s[i].lower()
        else:
            answer += s[i]
    return answer