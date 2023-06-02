def solution(new_id):
    answer = ''
    # 1,2단계
    for char in new_id:
        if not char.islower():
            new_id = new_id.replace(char, char.lower())
        if char in "~!@#$%^&*()=+[{]}:?,<>/":
            new_id = new_id.replace(char, '')

    # 3단계
    while ".." in new_id:
        new_id = new_id.replace("..", ".")

    # 4단계
    if new_id[0] == ".":
        if len(new_id) >= 2:
            new_id = new_id[1:]
    if new_id[-1] == ".":
        new_id = new_id[:-1]

    # 5단계
    short_id = ""
    if len(new_id) == 0:
        new_id += "a"

    # 6단계
    if len(new_id) >= 16:
        for i in range(0, 15):
            short_id += new_id[i]
        if short_id[-1] == ".":
            short_id = short_id[:-1]
        new_id = short_id

    # 7단계
    if len(new_id) <= 2:
        while True:
            new_id += new_id[len(new_id) - 1]
            if len(new_id) == 3:
                break

    answer = new_id
    return answer

