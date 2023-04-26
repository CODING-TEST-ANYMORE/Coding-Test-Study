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
			//입력 받은 중요도를 우선순위큐에 넣어 중요도가 큰것부터 push되게 하기
			pq.push( priority );
			//q에 pair자료형으로 중요도와 인덱스 저장
			q.push({ priority ,j});
		}
		//몇번째로 출력되는지 확인하는 변수 num
		int num = 1;
		while (!pq.empty()) {
			//q의 front가 우선순위가 가장 높은 값일 때
			if (pq.top() == q.front().first) {
				if (index == q.front().second) { //내가 찾는 index면 num출력
					cout << num << "\n";
					break;
				}
				//내가 찾는 index가 아니라면 두개의 queue를 모두 pop
				pq.pop();
				q.pop();
				num++;
			}

			//아니라면 q를 pop하고 다시 push
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



