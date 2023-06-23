#include<iostream>
#include<cstring>
#include<vector>
#include<queue>
#include <utility>
using namespace std;

int dp[5001];
int n;

int main() {
	cin >> n;

	//초기값 설정
	dp[3] = 1;
	dp[5] = 1;

	for (int i = 6; i <= n; i++) {
		if (dp[i - 3]) { //3을 뺀 값이 존재하면 과거 값에 +1
			dp[i] = dp[i - 3] + 1;
		}
		if (dp[i - 5]) { //위 로직이 실행되었을 수도 있으니(3,5 공배수) min을 통해 작은 값 선택  
			dp[i] = dp[i] ? min(dp[i], dp[i - 5] + 1) : dp[i - 5] + 1;
		}
	}

	if (!dp[n]) {
		cout << -1;
	}
	else {
		cout << dp[n];
	}



}