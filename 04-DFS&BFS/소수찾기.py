def isprime(num):
        number = int(num**(0.5)+1)
        for i in range (2, number):
            if num % i == 0:
                return 0
        return 1

def solution(n):
    a = 0
    for i in range (2, n+1):
        if isprime(i) == 1:
            a += 1
    return a