# 5. Coloring Houses
# The city of Hackerland can be represented with an even
# number n houses arranged in a row. A painter must paint the houses
# using at most three colors. The following conditions must hold true:
# 1. No two adjacent houses are the same color.
# 2. The houses which are at the same distance from both ends must not
# be colored with the same color. For example, n=6 then houses will be
# [1,2,3,4,5,6], so the houses at the same distance from both the ends
# will be [1,6], [2,5], [3,4].
# The task is to find the number of ways to paint the houses using at
# most three colors such that both the above conditions hold true.
# Since the answer can be large, report it modulo 109 7. Two ways are
# considered different if at least one house is colored differently.
# Example
# For n = 4, some of the possible valid arrangements are:
# (color1, color 2, color3, color2)
# (color1, color3, color1, color3)
# The number of ways to paint 4 houses using three colors is 18.
# Return 18 modulo (109 . 7) which is 18.
# Function Description
# Complete the countWaysToColorHouses function in the editor
# below.
# countWaysToColorHouses takes in a single parameter:
# int n: the number of houses
# Return
# int: the number of ways in which the houses can be colored,
# calculated as a modulo of (109+7)

# Python3 implementation of the
# above approach

mod = 1000000007

# Function to calculate the number of ways

# Python3 implementation of the
# above approach

modd = 1000000007


def count_sequences(n):
    dp = [[0] * (n // 2 + 1) for _ in range(n + 1)]
    dp[1][0] = 3
    for i in range(2, n + 1):
        for j in range(min(i // 2, n // 2) + 1):
            if j == 0:
                dp[i][j] = 3 * dp[i - 1][j + 1]
            elif j == 1:
                dp[i][j] = 2 * dp[i - 1][j - 1] + 2 * dp[i - 1][j + 1]
            else:
                dp[i][j] = 2 * dp[i - 1][j - 1]
    return sum(dp[n])


def power(x, y, p):
    res = 1  # Initialize result

    x = x % p  # Update x if it is more
    # than or equal to p

    while (y > 0):

        # If y is odd, multiply x with result
        if (y & 1):
            res = (res % p * x % p) % p

        # y must be even now
        y = y >> 1  # y = y/2
        x = (x % p * x % p) % p

    return res


# Function to calculate the number of ways
def ways(n):
    return power(2, n - 1, modd) * 3 % modd


if __name__ == '__main__':
    result = ways(3)
    sub = count_sequences(1)
    print(result, sub)
