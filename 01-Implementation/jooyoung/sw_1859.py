import sys

sys.stdin = open("../../../../sds sw/sw samsung/input_1859.txt", "r")

N = int(input())
for test_case in range(N):
    M = int(input())
    arr = list(map(int, input().split()))
    answer = 0
    sellPrice = 0

    for val in arr[::-1]:  # 뒤에서 부터 접근
        if val >= sellPrice:
            sellPrice = val
        else:
            answer += sellPrice - val

    print("#{} {}".format(test_case, answer))
