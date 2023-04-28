#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>


#include <queue>
using namespace std;
const int MAX = 1000001;

int T,k,n;
char c;
int main() {
	//아래 두개 안넣어줘서 시간초과가 났었는데 해결

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> k;
		priority_queue<pair<int,int>>high_pq; //가중치가 큰 것을 위로 올라가게 하는 우선순위 큐
		priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> low_pq; //낮은 것을 우선으로 하는 우선순위 큐

		bool visited[MAX] = { false, }; // 한쪽 큐에서 삭제되었다면 다른쪽 큐에서도 노드를 삭제하기 위한 배열
		for (int j = 0; j < k; j++) {
	
			cin >> c;
			cin >> n;

			if (c == 'I') {
				high_pq.push({ n ,j});
				low_pq.push({ n ,j});
				visited[j] = true; //인덱스로 현재 큐에 들어가 있다는 것을 확인
			}
			else {
			
			
					if (n == 1&&!high_pq.empty()) {
						visited[high_pq.top().second]=false; //큐에서 삭제
						high_pq.pop();
					}
					else if (n==-1&&!low_pq.empty()){
						visited[low_pq.top().second] = false;//큐에서 삭제
						low_pq.pop();			
					}

					//양쪽 큐에서 삭제된 값이 있으면 반대쪽 큐도 값 삭제
					while (!high_pq.empty() && !visited[high_pq.top().second]) {
						high_pq.pop();
					}
					while (!low_pq.empty() && !visited[low_pq.top().second]) {
						low_pq.pop();
					}
				}

		
			}
		if (high_pq.empty() || low_pq.empty()){ //둘 중 하나라도 비면 EMPTY
			cout << "EMPTY"<<"\n";
		}
		else {
			cout << high_pq.top().first << " " << low_pq.top().first << "\n";
		}

		}
	

	return 0;
}



