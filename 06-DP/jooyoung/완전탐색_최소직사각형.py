def solution(sizes):
    answer = 0
    area = []
    new_area = []
    big_area = 0
    w_big = 0
    l_big = 0

    for i in range(len(sizes)):
        area.append(sizes[i][0] * sizes[i][1])
        if big_area < area[i]:
            big_area = area[i]
        if w_big < sizes[i][0]:
            w_big = sizes[i][0]
        if l_big < sizes[i][1]:
            l_big = sizes[i][1]
    if w_big >= l_big:
        bigg = w_big
    else:
        bigg = l_big

    for i in range(len(sizes)):
        if bigg * sizes[i][0] >= big_area:
            new_area.append(bigg * sizes[i][0])
        if bigg * sizes[i][1] > big_area:
            new_area.append(bigg * sizes[i][1])
    new_area.sort()
    answer = new_area[0]
    return answer


def solution2(sizes):
    answer = 0
    width = []
    length = []
    for i in sizes:
        if i[0] >= i[1]:
            width.append(i[0])
            length.append(i[1])
        elif i[0] < i[1]:
            width.append(i[1])
            length.append(i[0])
    width.sort()
    length.sort()
    answer = width[-1] * length[-1]
    return answer