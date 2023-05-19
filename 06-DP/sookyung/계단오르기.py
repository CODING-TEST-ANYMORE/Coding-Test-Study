n=int(input()) # 계단 개수
s=[int(input()) for _ in range(n)] # 계단 
d=[0]*n

if len(s)<=2: #계단 2개 이하일경우 그냥 다 더함
    print(sum(s))
else:
    d[0]=s[0]
    d[1]=d[0]+s[1]
    
    for i in range(2,n):
        d[i]=max(d[i-3]+s[i-1]+s[i], d[i-2]+s[i])
        
    print(d[-1])    