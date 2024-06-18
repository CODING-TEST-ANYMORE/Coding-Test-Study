#include <iostream>
#include <vector>
#include <utility> 
#include <algorithm>
using namespace std;

int v, e; // 노드와 간선의 개수 (최대 10만개)
int parent[100001]; // 부모 테이블 초기화 
vector<pair<int, pair<int, int>>> edges; // 모든 간선을 담을 배열 
int result = 0; 

// 특정 원소가 속한 집합 찾아내기 
int findParent(int x){
	// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀 호출 
	if(x == parent[x]) return x; 
	return parent[x] = findParent(parent[x]);
}

// 두 원소가 속한 집합을 합치기 
void unionParent(int a, int b){
	a = findParent(a);
	b = findParent(b);

	// 더 작은 번호가 부모 노드가 되도록 
	if(a < b) parent[b] = a;
	else parent[a] = b; 
}

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> v >> e; 

	// 부모 테이블 초기화 
	for(int i = 1; i <= v; i++){
		parent[i] = i;
	}

	// 모든 간선에 대한 정보 입력 받기 
	for(int i = 0; i < e; i++){
		int a, b, cost; 
		cin >> a >> b >> cost;
		edges.push_back({cost, {a, b}});
	}

	// 간선을 비용 순으로 정렬 
	sort(edges.begin(), edges.end());

	// 간선을 하나씩 확인하면서 
	for(int i = 0; i < edges.size(); i++){
		int cost = edges[i].first; 
		int a = edges[i].second.first; 
		int b = edges[i].second.second; 

		// 사이클이 발생하지 않는 경우에만 MST에 포함시키기 
		if(findParent(a) != findParent(b)){
			unionParent(a, b);
			result += cost; 
		}
	}

	cout << result; 

	return 0; 
}