#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int mem[1000] = { 1,2,4, };
int T, n;
int sum123(int n) {
	if (n == 1 || n == 2)
		return n;
	else if (n == 3)
		return 4;
	else {
		mem[n] = sum123(n - 1) + sum123(n - 2) + sum123(n - 3);
	}
	return mem[n];
}
int main()
{
	cin >> T;

	for (int i = 0; i < T; i++) {
		scanf("%d", &n);
		cout << sum123(n) << endl;
	}

	return 0;
}