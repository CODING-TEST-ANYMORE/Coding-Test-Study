#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>
#include <sstream>
#include <stack>
#include <queue>
using namespace std;

stack<int>stk;
string str;
int main() {
	int loof = 1;
	int check = 0;
	while (1) {
		int res = 0;
		char c = '-';
		cin >> str;

		if (str.find(c) != string::npos) { //문자열중 문자가 포함되는지 여부확인
			break;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str[i] == '{') {
				stk.push(str[i]);  
			}
			else {
				if (!stk.empty() && stk.top() == '{') { //괄호가 정상적으로 닫힐 수 있는 경우 stack에서 제거
					stk.pop();
				}
				else { //정상적이지 않을 때는 변경해서 넣어줌
					res++; 
					stk.push('{');
				}
			}
		}
		if (stk.empty()) { // 변경을 통해 괄호가 정상적으로 닫혀서 스택이 비면 변경횟수만 출력
			cout << "빈스택\n";
			cout << loof << ". " << res<<"\n";
		}
		else {
			cout << loof << ". " << stk.size()/2+res << "\n"; 
			//변경을 해도 스택이 비지 않았을 때는 변경횟수 + stack의 사이즈를 2로 나눈값 출력
			while (!stk.empty()) {
				stk.pop();
			}
		}
		loof++;
	}
	return 0;
}



