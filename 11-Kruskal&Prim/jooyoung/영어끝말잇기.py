def solution(n, words):
    answer = []
    list_w = [[] for _ in range(n)]
    k = 0
    dup = {x for x in words if words.count(x) > 1}
    dup = list(dup)
    dic = {}

    for i in range(len(words) // n):
        for j in range(n):
            list_w[j].append(words[k])
            k += 1
    if len(words) != k:
        for i in range(len(words) - k):
            list_w[i].append(words[k])
            k += 1

    for i in range(len(words) - 1):
        if words[i][-1] != words[i + 1][0]:
            for j in range(n):
                if words[i + 1] in list_w[j]:
                    answer.append(j + 1)
                    answer.append(list_w[j].index(words[i + 1]) + 1)

    if len(answer) == 0:
        if len(dup) == 0:
            answer.append(0)
            answer.append(0)
        else:
            for i in range(n):
                if dup[0] in list_w[i]:
                    dic[i] = list_w[i].index(dup[0])
            answer.append(max(dic) + 1)
            answer.append(dic[max(dic)] + 1)

    return answer