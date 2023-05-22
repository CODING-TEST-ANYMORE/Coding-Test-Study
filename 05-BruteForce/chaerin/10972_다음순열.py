# 처음에 itertools 모듈의
# 순열, 조합 생성을 하는 permutations(), combinations() 등의 함수를 사용하려 하였으나 시간초과가 떠서 구글링하여 솔루션을 찾았습니다

n = int(input())
arr = list(map(int, input().split()))

for i in range(n - 1, 0, -1):  # 맨 뒤 값부터 시작
    if arr[i - 1] < arr[i]:
        for j in range(n - 1, 0, -1):  # 다시 맨 뒤 값부터 큰 값찾기
            if arr[i - 1] < arr[j]:
                arr[i - 1], arr[j] = arr[j], arr[i - 1]  # 둘 값을 swap
                arr = arr[:i] + sorted(arr[i:])
                for i in arr:
                    print(i, end=' ')
                exit()  # exit()이 아닌 break를 쓸 경우에는 제일 밖의 for문을 빠져나오지 못함

# 내림차순으로 정렬되어있는 경우
print(-1)
