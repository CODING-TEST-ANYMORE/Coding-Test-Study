import sys


n, m = map(int, input().split())
arr = []
max_value = 0

for _ in range(n):
        num = int(input())
        arr.append(num)
        max_value = max(max_value, num)

left = 0
right = max_value * 1000000000
ans = 0

while left <= right:
        mid = (left + right) // 2
        cnt = 0 # 주어진 시간내에 처리할 수 있는 심사 인원

        for num in arr:
            cnt += mid // num

        if cnt >= m:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

print(ans)


