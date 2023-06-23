#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int N,K;
queue<int> q;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}

	cout <<"<";
	int num = 1;
	while(!q.empty()){
		if (num == K) {
			if (q.size() == 1) {
				cout << q.front();
			}
			else {
				cout << q.front() << ", ";
			}
			
			q.pop();
			num = 1;
			continue;
		}

		int temp = q.front();
		q.pop();
		q.push(temp);
		num++;
	}
	cout << ">";

	return 0;
}
