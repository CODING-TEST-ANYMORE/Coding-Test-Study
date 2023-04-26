import sys
import heapq

n = int(sys.stdin.readline())

for _ in range(n):
    leftheap = []
    rightheap = []
    result = []
    n = int(sys.stdin.readline())

    for i in range(n // 10 + 1):
        nums = list(map(int, input().split()))
        for i in range(len(nums)):
            num = nums[i]
            if len(leftheap) == len(rightheap):
                heapq.heappush(leftheap, -num)
            else:
                heapq.heappush(rightheap, num)

            if rightheap and rightheap[0] < -leftheap[0]:
                leftValue = heapq.heappop(leftheap)
                rightValue = heapq.heappop(rightheap)

                heapq.heappush(leftheap, -rightValue)
                heapq.heappush(rightheap, -leftValue)

            if (i + 1) % 2 == 1:
                result.append(-leftheap[0])
    print(len(result))
    for x in result:
        print(x, end=' ')
