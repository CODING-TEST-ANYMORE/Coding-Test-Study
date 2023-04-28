# 1. How Many Flips?
# Start with an initial string of zeros. Choose any digit to flip. When a
# digit is flipped, its value and those to the right switch state
# between 0 and 1. Given a target string of binary digits, determine
# the minimum number of flips required to achieve the target.
# Example:
# target = 01011
# Start with a string of 5 zeros, the same length string as the target.
# Initial String -> 00000
# Flip the 3rd digit -> 00111
# Flip the 2nd digit -> 01000
# Flip the 4th digit -> 01011
# 3 flips are required to reach the target. The return value is 3.
# Function Description
# Complete the function minimumFlips in the editor below.
# minimumFlips has the following parameter(s):
# string target: a string of 0s and 1s to match
# Returns:
# int: the minimum number of flips needed to obtain the target
# string

def solution(target):
    curr = '1'
    count = 0

    for i in range(len(target)):
        if (target[i] == curr):
            count += 1
            curr = chr(48 + (ord(curr) + 1) % 2)

    return count


if __name__ == '__main__':
    result = solution('01011')
    print(result)
