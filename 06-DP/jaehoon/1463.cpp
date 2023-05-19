
#include <bits/stdc++.h>
using namespace std;

int d[1000010];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n;

	//초기값 정의
	d[1] = 0;

	//2부터 n까지 for문 
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0) d[i] = min(d[i], d[i / 2] + 1);
		if (i % 3 == 0) d[i] = min(d[i], d[i / 3] + 1);
	}

	cout << d[n];
}