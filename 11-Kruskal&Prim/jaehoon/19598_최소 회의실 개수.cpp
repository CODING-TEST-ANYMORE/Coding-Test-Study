#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef pair<int, int>pil;

int N, start, e;
int  cnt = 0, res = 0;
vector<pil> v;

int main(void) {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) { // 시작하는 시간은 1, 끝나는 시간은 -1로 vector에 삽입
		cin >> start >> e;
		v.push_back(make_pair(start, 1));
		v.push_back(make_pair(e, -1));

	}
	sort(v.begin(), v.end()); //오름차순 정렬


	for (int i = 0; i < v.size(); i++) {
		if (v[i].second == 1) { //시작할 때 +1 끝날때 -1해서 최대값 구함
			cnt++;
			res = max(cnt, res);
		}
		else {
			cnt--;
		}
	}

	cout << res;


	return 0;
}
