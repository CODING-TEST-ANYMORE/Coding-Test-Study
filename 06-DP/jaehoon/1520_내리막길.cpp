#include<iostream>
#include<cstring>
#include<vector>
using namespace std;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int map[500][500];
int cache[500][500];
int n, m;
// (curX, curY)�������� ���������� ���� ����� ��
int downhill(int curX, int curY) {
	// ���������� return 1
	if (curX == (n - 1) && curY == (m - 1))
		return 1;
	// ���� ���߾����� Ȯ��
	int& ret = cache[curX][curY];
	if (ret != -1)return ret;
	// ���� ������ ������ ���ϱ�
	ret = 0;
	// �����¿� ���캸��
	for (int i = 0; i < 4; i++) {
		int nextX = curX + dx[i];
		int nextY = curY + dy[i];
		// map�� ����ų� ������������ �� ������� continue
		if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m ||
			map[curY][curX] <= map[nextY][nextX])
			continue;
		// �̵��� �� �ִ� �������� ��ε��� ���� �������������� ��μ�
		ret += downhill(nextX, nextY);
	}
	return ret;
}
int main() {
	memset(cache, -1, sizeof(cache));
	cin >> m >> n;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j]; //map �迭�� �Է�
	cout << downhill(0, 0);
}