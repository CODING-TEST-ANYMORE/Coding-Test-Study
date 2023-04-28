n = int(input())
nums = [] # 기싱의 리스트 생성
for i in range(n):
    nums += list(map(int,input().split())) # 리스트 형식으로 받아 저장
    nums.sort(reverse=True) # sort() 큰 숫자부터 와야해서 reverse
    nums = nums[:n] # n 크기 만큼 자르기
print(nums[-1]) # n번째 수