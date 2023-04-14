#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;

vector<pair<int, int>> p;
//vector<pair<int, int>> memo;
int memo[1001];
int N;
int cow_num, pos;

int res = 0;
int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> cow_num >> pos;
		p.push_back(make_pair(cow_num, pos));
	}
	for (int i = 0; i <=10; i++) {
	
		memo[i] = 2;
	}
	
	for (int i = 0; i < N; i++) {
		int temp = p[i].first;

		if (memo[temp - 1] == 2) {
			memo[temp - 1] = p[i].second;
			continue;
		}
		else if (memo[temp - 1] != p[i].second) {
			res++;
			memo[temp - 1] = p[i].second;
			continue;
		}
		else {
			continue;
		}

	}

	cout << res;
	return 0;
}



