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
		//�Է¹��� ���ڰ� 0�̾ƴϸ� push, 0�̸� pop
		if (num != 0) {
			stk.push(num);
		}
		else {
			stk.pop();
		}
	}
	int sum = 0;
	//stack �� ���ϱ�
	while (!stk.empty()) {
		sum += stk.top();
		stk.pop();
	}
	cout << sum;
	return 0;
}



