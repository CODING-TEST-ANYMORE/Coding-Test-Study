def solution(n, arr1, arr2):
    maps = []
    
    for i in range(n):
        maps.append(bin(arr1[i]|arr2[i])[2:])
        
        if len(maps[i]) < n:
            maps[i] = '0' * (n - len(maps[i])) + maps[i]
            
        maps[i] = maps[i].replace('1', '#')
        maps[i] = maps[i].replace('0', ' ')

    return maps