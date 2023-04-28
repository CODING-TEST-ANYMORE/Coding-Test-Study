# 4. Triplets
# Given an array of n distinct integers, d = [d[0], d[1], ..., d[n-1]], and
# an integer threshold, t, how many (a, b, c) index triplets exist that
# satisfy both of the following conditions?
# d[a] < d[b] < d[c]
# d[a] + d[b] + d[c] s t
# Example
# d = [1,2,3,4,5]
# t = 8
# The following 4 triplets satisfy the constraints:
# (1,2,3) - :
# (1,2,4)
# (1,2,5)
# (1,3,4)
# Function Description
# Complete the function triplets in the editor below.
# triplets has the following parameter(s):
# int t: an integer threshold
# int d[n]: an array of integers
# Returns:
# long: a long integer that denotes the number of (a, b, c) triplets
# that satisfy the given conditions


def solution(t, d):
    d.sort()
    cnt = 0
    n = len(d)
    for i in range(n - 2):
        left_ind, right_ind = i + 1, n - 1
        while left_ind < right_ind:
            sum = d[i] + d[left_ind] + d[right_ind]
            if sum > t:
                right_ind -= 1
            else:
                cnt += right_ind - left_ind
                left_ind += 1
    return cnt


if __name__ == '__main__':
    result = solution(8, [1, 3, 2, 4, 5])
    print(result)
