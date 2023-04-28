#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>


#include <queue>
using namespace std;

priority_queue<int> pq;
vector<int>v;
int num;
int empty_q = 0;
int main() {
	cin >> num;
	int x;
	for (int i = 0; i < num; i++) {
		cin >> x;
		if (x == 0) {
			if (pq.empty()) {
				v.push_back(0);
			}
			else {
				v.push_back(pq.top());
				pq.pop();
			}
		}
		else {
			pq.push(x);
		}

	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << "\n";
	}
	return 0;
}



