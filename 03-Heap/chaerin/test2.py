def solution(s):
    programmer = "programmer"

    head = programmer

    i = 0
    # programmer
    for c in s:
        idx = head.find(c)
        if idx != -1:
            head = head[:idx] + head[idx + 1:]

        if len(head) == 0:
            i += 1
            break
        i += 1

    tail = programmer

    j = len(s) - 1
    # programmer
    for c in reversed(s):
        idx = tail.find(c)
        if idx != -1:
            tail = tail[:idx] + tail[idx + 1:]

        if len(tail) == 0:
            j -= 1
            break
        j -= 1

    return j - i + 1


if __name__ == '__main__':
    result = solution('progxrammerrxproxgrammer')
    print(result)
