#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
#define MAX 10000+1
int V, E;
int parent[MAX];
vector<pair<int, pair<int, int>>> v;

int find(int x) {
	if (x == parent[x]) {
		return x;
	}
	else {
		return parent[x] = find(parent[x]);
	}
}

void Union(int x, int y) {
	x = find(x);
	y = find(y);

	if (x != y) {
		parent[y] = x;
	}
}

bool sameParent(int x, int y) {
	x = find(x);
	y = find(y);

	if (x == y) {
		return true;
	}

	else { 
		return false;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int v1, v2, cost;
	int result = 0;
	cin >> V >> E;

	for (int i = 0; i < E; i++) { //시작 노드, 도착 노드, 가중치 입력받기
		cin >> v1 >> v2 >> cost;
		v.push_back(make_pair(cost, make_pair(v1, v2)));
	}
	sort(v.begin(), v.end()); // 오름차순 정렬 

	for (int i = 1; i <= V; i++) { //부모의 초기 값은 자기 자신
		parent[i] = i; 
	}

	for (int i = 0; i < E; i++) { // 두 노드가 동일하지 않다면 둘을 이어주는 Union 함수 실행 후 가중치 더하기
		int vertex1 = v[i].second.first;
		int vertex2 = v[i].second.second;
		if (!sameParent(vertex1, vertex2)) {
			Union(vertex1, vertex2);
			result += v[i].first;
		}
	}
	cout << result<<"\n";

	return 0;
}
