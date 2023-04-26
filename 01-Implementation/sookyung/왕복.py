n, k = map(int,input().split())
m = list(map(int, input().split()))

for i in range(n):
    k-=m[i] 
    if k < 0:
        print(i+1)
        break
else:
    for i in range(n):
        j = n - i -1 
        k-=m[j]
        if k < 0:
            print(j+1)
            break