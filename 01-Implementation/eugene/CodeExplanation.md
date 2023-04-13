
~하.... 2시간동안 썼는데  날라간 저의 코드 소개글....한문제 남았었는데....^^...~

## 문제 링크

거북이 [실버2] - https://www.acmicpc.net/problem/8911  
왕복 [실버1] - https://www.acmicpc.net/problem/18311  
주사위 굴리기 [골드4] - https://www.acmicpc.net/problem/14499  
신고결과 받기 [Level2] - https://school.programmers.co.kr/learn/courses/30/lessons/92334  
옹알이(2) [Level1] - https://school.programmers.co.kr/learn/courses/30/lessons/133499  
JadenCase 문자열 만들기 [Level 2] - https://school.programmers.co.kr/learn/courses/30/lessons/12951  

<br>

## 목차

[1. 거북이](#거북이)
[2. 왕복](#왕복)
[3. 주사위 굴리기](#주사위-굴리기)
[4. 신고 결과 받기](#신고-결과-받기)
[5. 옹알이(2)](#옹알이2)
[6. JadenCase 문자열 만들기](#jadencase-문자열-만들기)

> **Warning** 2시간동안 쓴 마크업이 날라가서 사담이 많음..하...
> 질문, 피드백..plz...환영합니다 🥰
  
 <br>
  
## 거북이

<br>

```python
dx = [0, -1, 0, 1]  
dy = [1, 0, -1, 0]
```
  
우선 저는 상좌하우(남서북동) 좌표를 만들어 줬습니다. 오른쪽으로 돌려줘도 되는데...저는 왼쪽을 좋아합니다.  
흔한 인덱스로 접근하는 방식을 생각해 봤습니다.
```python
        if j == 'L': 
            if direction == 3: 
                direction = 0
            else:
                direction += 1
        elif j == 'R':
            if direction == 0:
                direction = 3
            else:
                direction -= 1
```
<br>

방향을 왼쪽으로 틀 경우에는 `+= 1`을, 오른쪽일 경우는 `-=1`을 해줬습니다.  

```python
        elif j == 'F':
            x += dx[direction] 
            y += dy[direction]
            list_x.append(x)
            list_y.append(y)
        else:
            x -= dx[direction]
            y -= dy[direction]
            list_x.append(x)
            list_y.append(y)
```
<br>
이부분이 조금 더럽다고 생각할 수 있쥐만,,,,  
끝마치고 넣기에는 `'L','R'`의 경우에는 불필요한 행동이고, 그때그때 최소,최대를 계산 해주기엔 시간 낭비인것 같아서  
이런식으로 넣어줬습니다.
<br>

```python
    print(abs(max(list_x)-min(list_x)) * abs(max(list_y)-min(list_y)))
```

그리고 파이썬에 있는 아주아주 소중한 절댓갓을 주는 `abs()`를 사용해서 ~다른 언어에도 있나요...?몰라서,,,~  
(파이썬 살앙해~!~!~!)
큰값에서 작은 값을 빼주고 각자 더해서 넓이를 구했습니다.

  
  

## 왕복
<br>

```python
m = list(map(int,input().split()))
m = m+m[::-1] 
```
  
우선 저는 뭔가...표본을 만들어서 푸는걸 좋아합니다...  
그래서 왕복 표본을 만들어 줬습니다...^^ 기존의 `m`에 `m[::-1]`을 통해서 반대의 리스트를 붙여줬습니다.  
<br>

```python
for i in range (n*2) :
    k -= m[i] 
    if k < 0:
        if i > n:
            print((n*2) - i )
            break
        else: 
            print(i+1)
            break
```

그래서 `for`문도 당연히 `n*2` 식으로 넣어주고, 끝점을 찍었을 경우 (i가 n보다 클 경우)  
`(n*2) -1`을, 아닐경우 +1을 `print` 해줬습니다.
사실 저는 프로그래머스만 풀었어서 함수로만 썼었는데, 제가 `return` 하고도 끝나질 않는줄 알고 한참 고민했습니다.^^...


  <br><br>
   
## 주사위 굴리기
  
```python
def move(direction):
    if direction == 1:
        dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
    elif direction == 2:
        dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
    elif direction == 3:
        dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]
    else:
        dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
```
  
하... 이실직고 하겠습니다. 주사위 공식을 찾질 못해서 이부분은 구글의 도움을 얻었습니다^^...👎👎우우,,,  
사실 아직도 완전히 이해는 안돼서 완벽히 이해하시는 분은 Help....  
  
```python
for i in go:
    nx = x + dx[i-1] 
    ny = y + dy[i-1] 
    if 0 <= nx < n and 0 <= ny < m: 
        x,y = nx,ny
        move(i)
        if maps[x][y] == 0: 
            maps[x][y] = dice[0] 
        else:
            dice[0] = maps[x][y]
            maps[x][y] = 0
        print(dice[5])
```
<br>

사실 문제 자체는 어렵지 않은 것 같은데 주사위 공식 때문에 난이도가 높은것 같아요...  
그 이후는 흔하게 `dx,dy`를 통해 인덱스 찾아주고, `nx,ny`라는 가상의 변수를 만들어 줬습니다.  
후에 있는 조건문에 맞다면 `x,y`의 값을 바꿔주고 아닌경우는 영향 없도록 하기 위함이었습니다.  
그 후 조건에 맞게 0일 경우에는....**더보기**
  
<br><br>
  
  
에... 장난입니다. 절대 쓰기 귀찮은게 아니예요.  
0일 경우에는 주사위의 값을 붙이고, 아닌 경우에는 주사위에 해당 좌표의 값을 붙이고 좌표는 0으로 만들어 줬습니다.  
그 후 결과 값은 주사위의 `dice[5]`를 출력해줬습니다.
  
<br><br>
  
## 신고 결과 받기
  
<br>

```python
    result = [0] * len(id_list)
    id_dict = {}
    sam_dict = {}
```
<br>

이 문제가...좀 어려웠습니다. 아마 정답률도 낮았던것 같아요.  
제가....위에 표본을 만들어서 푸는걸 좋아한다고 말씀드렸는데 이것도 표본 맹글었습니다.  
문제를 보고 `dictionary`를 사용하면 어떨까 싶었습니다. 사실 나름의 이유가 있긴 했는데 궁금하다면.. 따로 얘기를 나눠보는걸로...  
<br>

```python
    for i in id_list:
        id_dict[i] = 0 
        sam_dict[i] = []
```

우선 표본을 만들어야 하기 때문에 `id_dict[i] = 0` 으로 `dictionary` 생성해주고,  
반대로 신고를 한 표본도 만들어 주기 위해서 `sam_dict[i]`를 만들어 줬습니다.  
<br>

```python
    for j in set(report):
        j = j.split() 
        id_dict[j[1]] += 1 
        sam_dict[j[0]].append(j[1])
```
본격적으로 신고당한 횟수를 세는 부분입니다.   
그 전에 같은 사람이 같은 사람을 두번 신고하는 일을 방지하기 위해 저는 `set()`을 넣어줬어요.  
그리고 `id_dict`를 통해서 신고당한 횟수와 `sam_dict`를 통해 A:(A가 신고한 사람들) 이런식으로 저장해줬습니다.  
<br>

```python
    for x,y in id_dict.items():
        if y >= k: 
            for i,j in sam_dict.items():
                if x in j:
                    result[id_list.index(i)] += 1 
                    id_list +1  
```
<br>

그 후, 신고 횟수가 k 이상인 x 즉 카카오 캐릭터들을 찾아서, 그 카카오 캐릭터를 신고한 카카오 캐릭터를 sam_dict 에서 찾았습니다.  
그리고 처음에 만들어 줬던    ` result = [0] * len(id_list)` 에 인덱스 번호로 접근해서 해당 캐릭터를 `+= 1` 넣어줬습니다.  
인덱스로 접근을 위해... 처음에 for문으로 딕셔너리를 맹글었습니다. 큰그림 대박이죠. 그렇다고 해주세요. 👀



<br><br>

## 옹알이(2)

<br>

```python
def solution(babbling):
    answer = 0
    can = ["aya","ye","woo","ma"]   
    
    for i in babbling:                  
        for j in can:            
            if j+j not in i: 
                i = i.replace(j,' ')
        if i.strip()=='':     
            answer+=1       
            
    return answer
```

이 문제는 짧아서 전문을 가져와 봤습니다. 이게 사담이 긴데..길어서 접어두겠습니다...궁금하신분은  
<details><summary>진짜 더보기</summary>
하... 제가 아직도 지옥의 옹알이 문제라고 부릅니다. 이거랑 비슷한 옹알이(1)이 Level 0에 있는데요,
제가 이 문제로 처음 코테를 접했었어요. 그때는 아무것도 모르고 Level 0 짜리가 젤 쉬운건데 나는 이것도 어려워하면 정말 어떡하나 하며 엉엉 했었죠...  
근데 지금 봐도 이해가 안가네요 이게 어떻게 Level 0..? 🤧🤧 아마 정답률도 20프로 였던것 같아요 ㅋㅋㅋㅋㅋㅋ  
이 문제로 처음으로 문자열을 빈 공간으로 바꾼다는 발상을 배웠죠...^^,,,, 지옥의 옹알쓰
</details>    
<br>

저는 표본을 좋아합니다...^^ 그래서 이번에도 옹알이를 할 수 있는 단어라는 뜻에서 `can`이라는 리스트를 만들어줬어요.  
그리고 연속된 단어는 하지 못한다는 조건이 있었기 때문에, `j+j`가 아닌 경우에만 j안 문자를 `' '`로 만들어 줬습니다.  
그 후 우리 사랑스러운 파이썬의 `strip()`을 통해서 공백을 지워주고 그 후에 결과값이 `''`일 경우에, `answer += 1` 해줬습니다.
이제 그만 옹알대도록.


<br><br>

## JadenCase 문자열 만들기

<br>

```python
for i in s:
        if answer == '': 
            answer = i.lower()
            answer = i[0].upper()
            continue
```

이 문제는 주어진 조건을 if 문으로 각각 처리했습니다.  
우리의 사랑스러운 파이썬의 `lower()`과`upper()`을 사용해서 첫 단어의 첫 글자만 대문자 처리를 해줬습니다.     
~다른 언어도 있나요 진짜 모름 저 사실 파이썬으로만 했어요^^..~   

<br>

```python
if i == ' ': 
            answer += i
        else: 
            if answer[-1] == ' ':
                if i.isdigit():
                    answer += i 
                else:
                    answer += i.upper() 
            else:
                answer += i.lower()
```
<br>

그 후는 띄어쓰기가 있을 경우 그 공백을 그대로 받고,  
그 전이 공백일 경우에는 대문자가 나와야 하기 때문에, 사랑스러운 파이썬의 `isdigit()`를 사용해서 숫자인지 확인하고,  
아닐경우 대문자 처리를 해줬습니다. 어라 지금보니 한줄로 줄여도 되네요.

<br>

```python
if i == ' ': 
            answer += i
        else: 
            if answer[-1] == ' ':
                    answer += i.upper() 
            else:
                answer += i.lower()
```

이렇게 해주면 될것 같네요 휴먼이슈 인정하시죠? 봐주세요.  
이것도 사담인데 제가 아까 잘못 올린거 하나 지우다가 뭘 잘못 건드려서 이상한게 잔뜩 생겨서.... 건드리기 무서워서 여기다가 수정할게요..^^...  
다들 설명 글 보시겠죠..?  


<br><br>


설명글 끝입니다. 질문...피드백...언제나 환영합니다. 다들 이번주 고생하셨어요~!~!~😊😊
