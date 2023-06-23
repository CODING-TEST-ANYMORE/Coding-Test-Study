#include <iostream>
using namespace std;

int main(void) {
	int arr[21] = { 0, };

	arr[0] = 0;
	arr[1] = 1;

	for (int i = 2; i < 21; i++) {
		arr[i] = arr[i - 1] + arr[i - 2];
	}
	int n;
	cin >> n;

	cout << arr[n] << endl;

}
