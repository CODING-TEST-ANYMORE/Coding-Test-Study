N, X = map(int, input().split())

if N > X or N * 26 < X:
    print('!')
else:
    arr = ['A'] * N
    X -= N
    i = N - 1

    while X > 0:
        if X >= 25:
            arr[i] = 'Z'
            i -= 1
            X -= 25
        else:
            arr[i] = chr(X + 65)
            break

    print(''.join(arr))
