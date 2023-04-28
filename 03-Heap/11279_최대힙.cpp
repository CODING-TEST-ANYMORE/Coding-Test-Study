#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>
#include <stack>

//11279
using namespace std;
int N;

stack<int> st;
vector<int>v;
priority_queue<int>pq;

int main() {
	cin >> N;
	int a;
	for (int i = 0; i < N; i++) {
		cin >> a;
		if (a == 0) {
			if (pq.empty()) {
				v.push_back(0);
			}
			else {
				v.push_back(pq.top());
				pq.pop();
			}
		}
		else {
			pq.push(a);
		}
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << "\n";
	}

	}



