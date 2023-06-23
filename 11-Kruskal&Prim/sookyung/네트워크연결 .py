def find(a):
    if a == arr[a]:
        return a
    arr[a] = find(arr[a])
    return arr[a]

def union(from_node, to_node):
    a = find(from_node)
    b = find(to_node)
    if a != b:
        arr[a] = b
        return True
    return False

n = int(input())
m = int(input())
arr = [i for i in range(n+1)]

networks = []
for _ in range(m):
    network = list(map(int, input().split()))
    networks.append(network)

networks.sort(key=lambda x: x[2])

res = 0
for network in networks:
    if union(network[0], network[1]):
        res += network[2]

print(res)
