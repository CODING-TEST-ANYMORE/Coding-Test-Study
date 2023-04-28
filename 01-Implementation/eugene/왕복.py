n,k = map(int,input().split())
m = list(map(int,input().split()))
m = m+m[::-1] # 왕복 루트 리스트

for i in range (n*2) : # 왕복의 길이는 n*2 
    k -= m[i] # 인덱스 만큼 빼주기
    if k < 0: # 0보다 작아질 경우 답 
        if i > n: # 끝 점을 찍고 돌았을 경우에는 식이 (n*2 - i)
            print((n*2) - i )
            break
        else: # 끝 점을 찍기 전 일 경우는 i+1
            print(i+1)
            break