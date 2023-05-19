#include<iostream>
#include<cstring>
#include<vector>
using namespace std;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int map[500][500];
int cache[500][500];
int n, m;
// (curX, curY)지점에서 도착점까지 가는 경로의 수
int downhill(int curX, int curY) {
	// 도착했으면 return 1
	if (curX == (n - 1) && curY == (m - 1))
		return 1;
	// 값을 구했었는지 확인
	int& ret = cache[curX][curY];
	if (ret != -1)return ret;
	// 값을 구한적 없으면 구하기
	ret = 0;
	// 상하좌우 살펴보기
	for (int i = 0; i < 4; i++) {
		int nextX = curX + dx[i];
		int nextY = curY + dy[i];
		// map를 벗어나거나 현재지점보다 더 높을경우 continue
		if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m ||
			map[curY][curX] <= map[nextY][nextX])
			continue;
		// 이동할 수 있는 곳에서의 경로들의 합이 현재지점에서의 경로수
		ret += downhill(nextX, nextY);
	}
	return ret;
}
int main() {
	memset(cache, -1, sizeof(cache));
	cin >> m >> n;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j]; //map 배열에 입력
	cout << downhill(0, 0);
}