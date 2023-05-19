#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;


vector<int>v1;
vector<int>v2;

int sum = 0;

int a, b, c;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int r, t;
	cin >> a >>b>>c;
	int temp=0,sum=0;
	int cnt[100] = { 0 };
	for (int i = 0; i < 3; i++) {
		cin >>r >> t;
		for (int j = r; j < t; j++) {
			cnt[j]++;
		}
	}

	for (int i = 0; i < 100; i++) {
		if (cnt[i] == 1) {
			sum += a;
		}
		else if (cnt[i] == 2) {
			sum += 2 * b;
		}
		else if (cnt[i] == 3) {
			sum += 3 * c;
		}
	}


	cout << sum;
	
		


		return 0;
}
