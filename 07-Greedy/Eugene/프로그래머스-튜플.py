def solution(s):
    s_dict = {}
    s = s.replace('{','').replace('}','').split(',')
    for i in s:
        i = int(i)
        if i in s_dict :
            s_dict[i] += 1
        else:
            s_dict[i] = 1
    return (sorted(s_dict, key = lambda x: s_dict[x], reverse = True))