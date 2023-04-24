## 시간 초과 

queue를 이용하든, deque를 이용하든, R 연산이 들어올 때마다 배열을 뒤집으면 반드시 시간초과가 발생한다. 

### queue, stack을 이용한 풀이 

```cpp
#include <iostream>
#include <algorithm>
#include <string>
#include <vector> 
#include <queue> 
#include <stack> 
using namespace std;

queue<int> q;

void reverseQueue(){
    stack<int> s;

	// 큐의 모든 원소를 스택에 옮긴다. 
    while (!q.empty()) {
        s.push(q.front());
        q.pop();
    }

	// 스택의 모든 원소를 다시 큐에 옮긴다. (순서가 뒤집어짐) 
    while (!s.empty()) {
        q.push(s.top());
        s.pop();
    }
}

void parseString(string arr) {
	string num = ""; // [42,21,99,100]
	int n = arr.size(); 
	
	for(int i = 1; i < n - 1; i++){
		char ch = arr[i]; 
		
		if(ch != ','){ 
			num += ch;
			
			if(i == n - 2){
				q.push(stoi(num)); 
			}
		}else{
			q.push(stoi(num)); 
			num = "";
		}
	}
}

void printQueue() {
	while(!q.empty()){ 
		cout << q.front() << " "; 
		q.pop(); 
	}
	cout << endl; 
}

void printArray() {	
	string str = "[";

	while(!q.empty()){ 
		string num = to_string(q.front()); // string으로 변환 필수!! 
		str += num;

		if(q.size() == 1){
			str += "]";
			q.pop();
			break;
		}
		
		str += ","; 
		q.pop();
	}

	cout << str << endl; 
}

void clearQueue() {
	while(!q.empty()){
		q.pop(); 
	}
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

	int t; 
	cin >> t; 

	while(t--){ // 최대 100 
		string p;
		cin >> p; // 최대 10만 

		int n;
		cin >> n; // 최대 10만 

		string arr; 
		cin >> arr;

		parseString(arr);
	
		bool isError = false; 
	
		// 명령어에 따라 queue를 조작한다.
		for(int i = 0; i < p.size(); i++){
			char cmd = p[i];
			
			if(cmd == 'R'){
				reverseQueue();
			}else{
				// 큐가 비어있는데 D 연산이 들어오면 error 
				if(q.empty()){
					cout << "error\n"; 
					isError = true; 
					break; 
				}

				q.pop();
			}
		}

		if(!isError){
			printArray();
			clearQueue();
		}
	}
    
    return 0;
}
```

### deque를 이용한 풀이 

```cpp
#include <iostream>
#include <vector>
#include <string>
#include <deque>
#include <algorithm> // for reverse
using namespace std;

string s;
deque<int> dq;

void tokenString(int i) {
	// 두자리 이상의 숫자가 들어올 수 있으니까 
	// 콤마 사이의 부분 문자열을 추출하고 그걸 int로 바꿔서 벡터에 push!
	string sub = "";
	while (s[i] != ',' && i < s.size() - 1) {
		sub += s[i];
		i++;
	}
	dq.push_back(stoi(sub));

	// 콤마가 발견된 바로 그 다음 위치(i+1)부터 다시 토크나이징! 
	if (i + 1 < s.size() - 1) {
		tokenString(i + 1); // 탐색 시작 위치만 바꿔서 재귀 호출
	}
	else {
		return;
	}
}

void printDeque() {
	cout << "[";
	for (int i = 0; i < dq.size(); i++) {
		if (i != dq.size() - 1) {
			cout << dq[i] << ",";
		}
		else {
			cout << dq[i];
		}
	}
	cout << "]\n";
}

int main()
{
	ios::sync_with_stdio(0);
    cin.tie(0);
	
	int t;
	cin >> t; 

	while (t--) { // 최대 100개 
		string p;
		cin >> p; // 배열을 변형할 문자열 (최대 길이 10만) 

		int n;
		cin >> n; // 배열 원소 개수 (최대 10만개)

		cin >> s; // 대괄호를 포함한 정수 배열 입력

		if (s != "[]") {
			tokenString(1);  // 숫자만 토크나이징 해서 덱에 저장  
		}
		else {
			cout << "error\n";
			continue;
		}

		// 덱 함수 이용해서 배열 변형 (+ 예외 처리)
		for (int i = 0; i < p.size(); i++) {
			if (!dq.empty()) {
				if (p[i] == 'R') {
					reverse(dq.begin(), dq.end());
				}
				else {
					dq.pop_front();
				}
			}
			else { // dq가 비어있으면 에러 출력, 다음 케이스로 이동 
				cout << "error\n";
				break;
			}
		}

		if (!dq.empty()) {
			printDeque();
			dq.clear(); // 다음 테스트 케이스를 위해 clear!
		}
	}

	return 0;
}
```

### 시간 초과가 발생하는 이유 

>첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

테스트 케이스는 최대 100개, p의 길이는 최대 10만, n의 크기도 최대 10만이다. 

최악의 상황을 생각해보자. 배열의 크기가 10만인 동시에 길이가 10만인 p의 연산이 모두 R이라고 해보자. 그러면, 10만개의 원소에 대해서 뒤집는 연산을 10만번 반복해야 한다. 테스트 케이스가 최대 100개인 것을 고려하면 실행 시간은 더욱 길어진다..! 

따라서, 이 문제는 주어진 입력 제한 조건을 보고 R 연산을 그대로 적용하면 안 된다는 사실을 파악해야 풀리는 문제다. 

## 직접 뒤집지 말자! 

직접 배열을 뒤집지 않고 R 연산을 적용하려면 어떻게 해야 될까? 바로 deque와 현재 방향을 나타내는 플래그 변수를 이용하여, deque의 앞이나 뒤를 삭제하면 된다. 

>- 뒤집어져 있을 때 'D' 명령어가 들어오면, pop_back으로 뒤의 원소를 제거하고
>- 뒤집어져있지 않을 때 'D' 명령어가 들어오면, pop_front로 앞의 원소를 제거한다.
>- 물론, 덱이 비어있을 때는 "error"를 출력한다.

R 명령어에 대해서 매번 실제로 reverse를 하면 시간 초과가 발생하므로, 덱 자료구조의 특성을 최대한 활용하여 실제 정수 배열을 뒤집는 것이 아니라 플래그 변수로 표시만 해두고, 그에 따라 원소를 pop 하는 부분(방향)을 달리 하는 것이다! 결과를 출력할 때도 마찬가지로, 뒤집어진 상태일 때는 back부터 출력하고, 뒤집어져 있지 않을 때는 front부터 출력한다.

### deque를 이용한 풀이 

```cpp
#include <iostream> 
#include <vector> 
#include <string>
#include <deque>
using namespace std;

deque<int> dq;

void parseString(string arr){
	string num = "";
	int n = arr.size();
	
	for(int i = 1; i < n - 1; i++){
		char ch = arr[i];
		
		if(ch != ','){
			num += ch;
			if(i == n - 2){
				dq.push_back(stoi(num));
			}
		}else{
			dq.push_back(stoi(num)); 
			num = "";
		}
	}
}

void printComma() {
	if(!dq.empty()){
		cout << ","; 
	}
}

void printForwardArray() {
	while(!dq.empty()){
		cout << dq.front();
		dq.pop_front();
		printComma(); 
	}
}

void printBackwardArray() {
	while(!dq.empty()){
		cout << dq.back(); 
		dq.pop_back();
		printComma(); 
	}
}

void printArray(bool forward){
	cout << "[";
	if(forward){
		printForwardArray(); 
	}else{
		printBackwardArray(); 
	}
	cout << "]\n";
}

int main() {
	ios::sync_with_stdio(0);
    cin.tie(0);

	int t;
	cin >> t; 

	while (t--) { // 최대 100
		string p;
		cin >> p; // 최대 10만
		
		int n;
		cin >> n; // 최대 10만
		
		string arr;
		cin >> arr;

		parseString(arr);
	
		bool isError = false;
		bool forward = true; // 정방향이면 true 
		
		for(int i = 0; i < p.size(); i++){
			if(p[i] == 'R'){
				// 방향 전환 
				forward = !forward;
			}else{
				// 비어있는데 삭제하려고 하면 에러 
				if(dq.empty()){
					isError = true;
					cout << "error\n";
					break;
				}

				// 현재 방향에 따라 앞이나 뒤의 원소 삭제 
				if(forward){
					dq.pop_front();
				}else{
					dq.pop_back();
				}
			}
		}

		if(!isError){
			// 현재 방향에 따라 배열 출력 
			printArray(forward);
		}
	}
	
	return 0;
}
```