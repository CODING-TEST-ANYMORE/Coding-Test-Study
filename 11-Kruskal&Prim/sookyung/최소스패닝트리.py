def find(x):
    if x != root[x]:
        root[x] = find(root[x])
    return root[x]


v, e = map(int, input().split())
root = [i for i in range(v + 1)]
arr = []
answer = 0

for _ in range(e):
    arr.append(list(map(int, input().split())))

arr.sort(key=lambda x: x[2])

for a, b, c in arr:
    arr1 = find(a)
    arr2 = find(b)

    if arr1 != arr2:
        if arr1 > arr2:
            root[arr1] = arr2
        else:
            root[arr2] = arr1
        
        answer += c

print(answer)