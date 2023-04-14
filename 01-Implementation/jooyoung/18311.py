N, K = map(int, input().split())

lengths = list(map(int, input().split()))
real_len = [0]

for i in range(len(lengths)):
    real_len.append(real_len[i] + lengths[i])

if K > real_len[-1]:
    K = K - real_len[-1]
    i = -1
    track = lengths[i]  # 5
    while True:
        if K > track:
            i = i - 1
            track += lengths[i]
        else:
            print(i + N + 1)
            break
else:
    for i in range(len(real_len)):
        if real_len[i] <= K < real_len[i + 1]:
            print(i + 1)
