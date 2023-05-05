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

int N, M;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int main() {
	cin >> N;

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int a;
	for (int i = 0; i < N; i++) {
		cin >>a;

		if (a == 0) {
			if (!pq.empty()) {
				cout << pq.top().second << "\n";
				pq.pop();
			}
			else {
				cout << 0 << "\n";
			}
		}
		else {
			pq.push({ abs(a),a });
		}

		

	}
	return 0;
}



