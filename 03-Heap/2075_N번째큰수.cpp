#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>


#include <queue>
using namespace std;
//greater 자료형을 넣어서 작은 숫자가 우선순위를 갖게
priority_queue<int,vector<int>,greater<int>> pq;
vector<vector<long long>>v;
vector<long long> v2;
int N;

int main() {
	//아래 두개 안넣어줘서 시간초과가 났었는데 해결
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr); 

	//ios_base::sync_with_stdio 구문은 c의 stdio와 cpp의 iostream을 동기화시켜주는 역할을 하는데, 이 때 iostream과 stdio의 버퍼를 모두 사용하기 때문에 딜레이가 발생합니다.
	//	따라서, ios_base::sync_with_stdio(false); 코드를 작성해줌으로써 동기화를 비활성화시켜줍니다.

	//기본적으로 cin으로 읽을 때 먼저 출력 버퍼를 비우는데, 마찬가지로 알고리즘을 풀 때는 화면에 바로 보이는 것이 중요하지 않습니다.
	//따라서, 입력과 출력을 여러 번 번갈아가며 반복해야 하는 경우 필수적으로 cin.tie(null); 코드를 추가하여 cout과 cin의 묶음을 풀어줘야 합니다.

	long long num;
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> num;
			pq.push(num);

			//pq가 N보다 커지면 메모리 초과가 날 수 있어서 작은수는 pop해줌
			if (pq.size() > N) {
				pq.pop();
			}
		}
	}
		//작은수가 우선순위고 size는 N이기 때문에 top하면 N번째로 큰 수
		cout << pq.top();
	



	return 0;
}



