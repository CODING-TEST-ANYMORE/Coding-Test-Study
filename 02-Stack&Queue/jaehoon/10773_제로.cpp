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
int K,num;
stack<int>stk;

int main() {
	
	cin >> K;

	for (int i = 0; i < K; i++) {
		cin >> num;
		//입력받은 숫자가 0이아니면 push, 0이면 pop
		if (num != 0) {
			stk.push(num);
		}
		else {
			stk.pop();
		}
	}
	int sum = 0;
	//stack 값 더하기
	while (!stk.empty()) {
		sum += stk.top();
		stk.pop();
	}
	cout << sum;
	return 0;
}



