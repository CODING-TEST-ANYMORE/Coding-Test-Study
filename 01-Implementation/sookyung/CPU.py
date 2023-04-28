arr = ["ADD", "SUB", "MOV", "AND", "OR", "NOT", "MULT", "LSFTL", "LSFTR", "ASFTR", "RL", "RR"]

def to_binary_number(num, length):
    ret = ""
    while num:
        ret = str(num % 2) + ret
        num //= 2
    ret = "0" * (length - len(ret)) + ret
    return ret

n = int(input())
for _ in range(n):
    opcode, num1, num2, num3 = input().split()
    flag = False
    if opcode[-1] == "C":
        opcode = opcode[:-1]
        flag = True
    for i in range(12):
        if arr[i] == opcode:
            ans = to_binary_number(i, 4)
            break
    ans += "1" if flag else "0"
    ans += "0"
    ans += to_binary_number(int(num1), 3)
    ans += to_binary_number(int(num2), 3)
    if flag:
        ans += to_binary_number(int(num3), 4)
    else:
        ans += to_binary_number(int(num3), 3)
        ans += "0"
    print(ans)