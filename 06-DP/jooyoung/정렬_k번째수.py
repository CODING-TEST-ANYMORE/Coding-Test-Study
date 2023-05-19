def solution1(array, commands):
    answer = []
    a = []
    for i in range(len(commands)):
        # for command in commands:
        # i,j,k = command
        # answer.append(list(sorted(array[i-1:j]))[k-1])
        l = commands[i][0] - 1
        j = commands[i][1]
        k = commands[i][2] - 1
        a = array[l:j]
        a.sort()
        answer.append(a[k])
    return answer