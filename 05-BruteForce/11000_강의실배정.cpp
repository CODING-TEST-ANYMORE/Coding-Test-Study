#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int N;
vector<pair<int, int>> list;
bool cmp_list(pair<int, int> x, pair<int, int>y) {
	//first ���� ��, second ���� ��
	if (x.first == y.first) {
		return x.second < y.second;
	}
	else return x.first < y.first;
}
struct cmp_pq { //�Ƹ� ������ ���� ���� (top�� ������ �ð��� ������ ��������)
	bool operator()(pair<int, int>x, pair<int, int>y) {
		return x.second > y.second;
	}
};
int main() {
	cin >> N;
	int s, t;
	for (int i = 0; i < N; i++) {
		cin >> s >> t;
		list.push_back({ s,t });
	}

	sort(list.begin(), list.end(), cmp_list);

	//�̺κ� Ȯ���ؾ���
	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp_pq> pq;

	pq.push(list[0]);
	for (int i = 1; i < list.size(); i++) {
		if (list[i].first >= pq.top().second) {
			pq.pop();
			pq.push(list[i]);
		}
		else {
			pq.push(list[i]);
		}
	}


	int ans = pq.size();
	cout << ans;

	}




