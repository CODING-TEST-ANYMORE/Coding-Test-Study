#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;


vector<int> v(26,0);
vector<int> b;
int c;
int sum = 0;

string s;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	

	

	for (int i = 0; i<s.size(); i++){
		for (int j = 0; j < 26; j++) {
			if (s[i] == j + 97) {
				
				++v[j];
				break;
			}
	}
	}

	for (auto a: v) {
		cout << a << " ";
	}

		return 0;
}
