#include <iostream> 
#include <vector>
#include <algorithm>
using namespace std;

int n; // 나무의 수 (최대 100만)
int m; // 가져가려는 나무 길이 (최대 20억)

const int MAX = 1000001; 
int tree[MAX]; // 각 나무 높이 최대 10억

bool decision(int height){
	long long total = 0; 

	for(int i = 0; i < n; i++){ 
		int gap = tree[i] - height; 
		if(gap > 0){ 
			total += gap; 
		}
	}

	return total >= m; 
}

int main() {
	ios::sync_with_stdio(0);
    cin.tie(0);

	cin >> n >> m;

	for(int i = 0; i < n; i++){
		cin >> tree[i]; 
	}

	int left = 0, right = 1e9; 
	while(left <= right){
		int mid = (left + right) / 2; 

		// true 구간의 최댓값을 구하자. 
		if(decision(mid)) left = mid + 1; 
		else right = mid - 1; 
	}

	cout << right; 

	return 0;
}
