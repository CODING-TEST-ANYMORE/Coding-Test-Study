def round_trip():
    n, k = map(int, input().split())

    courses = list(map(int, input().split()))

    for i in range(n):
        k -= courses[i]
        if k < 0:
            print(i + 1)
            break
    else:
        for i in range(n - 1, -1, -1):
            k -= courses[i]
            if k < 0:
                print(i + 1)
                break


if __name__ == '__main__':
    round_trip()
