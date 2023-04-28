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
	//�Ʒ� �ΰ� �ȳ־��༭ �ð��ʰ��� �����µ� �ذ�

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> k;
		priority_queue<pair<int,int>>high_pq; //����ġ�� ū ���� ���� �ö󰡰� �ϴ� �켱���� ť
		priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> low_pq; //���� ���� �켱���� �ϴ� �켱���� ť

		bool visited[MAX] = { false, }; // ���� ť���� �����Ǿ��ٸ� �ٸ��� ť������ ��带 �����ϱ� ���� �迭
		for (int j = 0; j < k; j++) {
	
			cin >> c;
			cin >> n;

			if (c == 'I') {
				high_pq.push({ n ,j});
				low_pq.push({ n ,j});
				visited[j] = true; //�ε����� ���� ť�� �� �ִٴ� ���� Ȯ��
			}
			else {
			
			
					if (n == 1&&!high_pq.empty()) {
						visited[high_pq.top().second]=false; //ť���� ����
						high_pq.pop();
					}
					else if (n==-1&&!low_pq.empty()){
						visited[low_pq.top().second] = false;//ť���� ����
						low_pq.pop();			
					}

					//���� ť���� ������ ���� ������ �ݴ��� ť�� �� ����
					while (!high_pq.empty() && !visited[high_pq.top().second]) {
						high_pq.pop();
					}
					while (!low_pq.empty() && !visited[low_pq.top().second]) {
						low_pq.pop();
					}
				}

		
			}
		if (high_pq.empty() || low_pq.empty()){ //�� �� �ϳ��� ��� EMPTY
			cout << "EMPTY"<<"\n";
		}
		else {
			cout << high_pq.top().first << " " << low_pq.top().first << "\n";
		}

		}
	

	return 0;
}



