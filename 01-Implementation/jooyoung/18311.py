N, K = map(int, input().split())

lengths = list(map(int, input().split()))
real_len = [0]

for j in range(len(lengths)):
    real_len.append(real_len[j] + lengths[j])

if K > real_len[-1]:
    K = K - real_len[-1]
    j = -1
    track = lengths[j]  # 5
    while True:
        if K > track:
            j = j - 1
            track += lengths[j]
        else:
            print(j + N + 1)
            break
else:
    for j in range(len(real_len)):
        if real_len[j] <= K < real_len[j + 1]:
            print(j + 1)
