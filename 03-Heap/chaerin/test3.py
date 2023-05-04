# Programmer String
# Test shortcuts
# A programmer string contains letters that can be rearranged to
# form the word 'programmer and is a substring of a longer string.
# Note that the strings 'programmer', 'grammproer', and
# 'prozmerqgram' are all classified as programmer strings by this
# definition. Given a string, determine the number of indices that lie
# between the rightmost and leftmost programmer strings that it
# contains.
# Example
# S = 'programmerxxxprozmerggram'
# 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
# Program me r xxxp r o zmerqgr a m
# In this example, indices 0 - 9 form one programmer string and
# indices 13 - 24 contain another. There are 3 indices between the
# programmer, so the function will return 3.
# Function Description
# Complete the function programmerStrings in the editor below.
# programmerStrings has the following parameter(s):
# string s: a string containing 2 programmer strings
# Returns:
# int: the number of indices which are between the rightmost and
# leftmost programmer strings within s
# Constraints
# String s consists of lowercase English alphabetic letters only, ascia-z].
# ≤ the length of s≤ 105.
# •
# There will always be two non-overlapping programmer strings.

def solution(s):
    programmer = "programmer"

    head = programmer

    i = 0
    # programmer
    for c in s:
        pIndex = head.find(c)
        if pIndex != -1:
            head = head[:pIndex] + head[pIndex + 1:]

        if len(head) == 0:
            i += 1
            break
        i += 1

    tail = programmer

    j = len(s) - 1
    # programmer
    for c in reversed(s):
        pIndex = tail.find(c)
        if pIndex != -1:
            tail = tail[:pIndex] + tail[pIndex + 1:]

        if len(tail) == 0:
            j -= 1
            break
        j -= 1

    return j - i + 1


if __name__ == '__main__':
    result = solution('programmerxxxprozmerqgram')
    print(result)
