import sys
sys.stdin = open("../../../../sds sw/sw samsung/input_1204.txt", "r")


T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    grades = list(map(int, input().split()))
    max_count = 0
    max_index = 0

    f = [0] * 101 # 0점 부터 100점 : arr 를 돌면서 그 점수에 맞도록 증가시켜줌
    # 점수 자체가
    for grade in grades:
        f[grade] += 1
        if f[grade] >= f[max_count]:
            max_count = grade
    print(max_count)


    # for i in range(len(arr)):
    #     val = arr.count(arr[i])
    #     if val >= max_count:
    #         max_count = val
    #         if arr[i - 1] >= arr[i]:
    #             max_index = i-1
    #         else:
    #             max_index = i
    #
    # print(arr[max_index])





