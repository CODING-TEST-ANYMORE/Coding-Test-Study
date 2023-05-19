x=int(input())
d=[0]*(x+1) # 게산되 낙ㅄ을 저장해줌 첫번째수는 1이아니라 2이기 떄문에 x+1이다.
for i in range(2,x+1):
    d[i]=d[i-1]+1
    d[i] = d[i - 1] + 1
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)	## d[i]에는 1을 더하지 않는 이유는 이미 앞에서 더해주었기 때문에..!
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
print(d[x])