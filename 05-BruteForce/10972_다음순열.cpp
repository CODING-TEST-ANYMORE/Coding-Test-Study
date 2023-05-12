#define _CRT_SECURE_NO_WARNINGS

#include <bits/stdc++.h>

using namespace std;



int main() {
	vector<int>v;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	if (next_permutation(v.begin(), v.end())) {
		for (int i = 0; i < n; i++) {
			cout << v[i] << " ";
		}

	}
	else {
		cout << -1;
	}

	return 0;
}

