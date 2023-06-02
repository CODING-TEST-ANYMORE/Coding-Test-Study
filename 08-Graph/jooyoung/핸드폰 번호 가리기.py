def solution(phone_number):
    answer = ''
    phone_list = []
    for i in phone_number:
        phone_list.append(i)
    for i in range(len(phone_list) - 4):
        phone_list[i] = '*'
    for i in range(len(phone_list)):
        answer += phone_list[i]
    return answer

