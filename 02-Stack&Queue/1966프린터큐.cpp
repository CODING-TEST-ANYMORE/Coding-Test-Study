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

int N,M;
int priority;
int main() {
	cin >> N;
	
	for (int i = 0; i < N; i++) {
		priority_queue<int> pq;
		queue<pair<int, int>> q;
		cin >> M;
		int index;
		cin >> index;

		for (int j = 0; j < M; j++) {
			cin >> priority;
			pq.push( priority );
			q.push({ priority ,j});
		}

		int num = 1;
		while (!pq.empty()) {

			if (pq.top() == q.front().first) {
				if (index == q.front().second) {
					cout << num << "\n";
					break;
				}
				pq.pop();
				q.pop();
				num++;
			}

			else {
				int value = q.front().first;
				int location = q.front().second;
				q.pop();
				q.push({ value,location });
			
			}
			
		}

	}
	return 0;
}



