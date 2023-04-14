#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>
#include <sstream>
#include <stack>
using namespace std;


string str;
vector<string> result;
stack<char>stk;

void printStack(stack<char> &stk) {
	while (!stk.empty()) {
		cout << stk.top();
		stk.pop();
	}
}
int main() {
	int check = 0;
	getline(cin,str);
	
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '<') {
			printStack(stk);
			check = 1;
			cout << str[i];
			continue;
		}
		else if (str[i] == '>') {
			check = 0;
			cout << str[i];
			continue;
		}

		else if (check == 1) {
			cout << str[i];
		}
		else if (str[i] == ' ') {
			printStack(stk);
			cout << str[i];
		}

	

		else {
			stk.push(str[i]);
		}
}
	printStack(stk);
	return 0;
}



