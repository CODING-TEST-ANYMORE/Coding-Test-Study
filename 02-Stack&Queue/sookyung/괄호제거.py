s = input()
v = []
st = []
''''('의 인덱스를 스택에 push하고, 닫는 괄호 ')'를 만나면 
스택에서 '('의 인덱스를 pop하여 v에 추가'''
for i in range(len(s)):
    if s[i] == '(':
        st.append(i)
    elif s[i] == ')':
        v.append((st.pop(), i))

ans = set()
n = len(v)
for i in range(1, 1 << n): #1부터 2^n-1까지
    erased = [False] * len(s)
    for j in range(n):
        if i & (1 << j):
            erased[v[j][0]] = erased[v[j][1]] = True
    tmp = ""
    for j in range(len(s)):
        if not erased[j]:
            tmp += s[j]
    ans.add(tmp)

for a in sorted(ans):
    print(a)