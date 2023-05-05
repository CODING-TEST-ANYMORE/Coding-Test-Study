#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <algorithm>

using namespace std;

int N;
int arr[10001] = { 0, };

int main()
{
	int money = 0, count = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	int i = 0;


	while (1) {

		if (i == N)
			break;
		if (arr[i] == 0) {
			i++;
		}

		else if (arr[i + 1] == 0) {
			arr[i]--;
			money += 3;
		}

		else if (arr[i + 1] > arr[i + 2])
		{
			arr[i]--;
			arr[i + 1]--;
			money += 5;
		}
		else if (arr[i + 1] <= arr[i + 2]) {
			arr[i]--;
			arr[i + 1]--;
			arr[i + 2]--;
			money += 7;
		}
		else {
			cout << "error";
		}




	}
	cout << money;
	return 0;
}







