#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;


vector<int>v;

int N;
int num;

long long sum = 0;
long long K;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		cin >> num;
		v.push_back(num);
		sum += num;
	}

		if (K >= sum) {
			K -= sum;
		
			for (int i = N-1; i >= 0; i--) {
				K -= v[i];

				if (K < 0) {
					cout << i + 1;
					break;
				}
				else if (K == 0) {
					cout << i;
					break;
				}
			}
		}

		else {
			for (int i = 0; i < N; i++) {
				K -= v[i];
				if (K < 0) {
					cout << i + 1;
					break;
				}
				else if (K == 0) {
					cout << i + 2;
					break;
				}
	
			}
		}
		return 0;
}
