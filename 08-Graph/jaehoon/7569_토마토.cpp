#include<iostream>
#include<cstring>
#include<vector>
#include<queue>
#include <utility>


using namespace std;

int dz[6] = { 0,0,0,0,-1,1 };
int dx[6] = { 0,0,1,-1,0,0 };
int dy[6] = { 1,-1,0,0,0,0 };

int M, N,H;

int visited[101][101][101] = { 0 }; // bfs활용시 날짜를 계산하는 배열 (dist로 할껄 그랬습니다..)
int tomato[101][101][101]; //토마토 입력 받는 배열
int result = 0;

queue<pair<pair<int, int>, int>> q;

void bfs() { //q가 빌때까지 순회하는 함수

	while (!q.empty()) {
		pair<pair<int, int>, int> cur = q.front(); 
		q.pop();

		for (int i = 0; i < 6; i++) {
			//현재 좌표에 x,y,z를 이동한 각각의 좌표를 만드는 코드
			int nz = cur.first.first + dz[i];
			int nx = cur.first.second + dx[i];
			int ny = cur.second + dy[i];

			//주변에 익지 않은 토마토가 있으면 그 전 토마토가 익은 날짜에 +1해줌 그리고 그 토마토 위치 다시 push
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
				if (visited[nz][nx][ny]==-1) {
					visited[nz][nx][ny] = visited[cur.first.first][cur.first.second][cur.second] + 1;
					q.push({ {nz,nx},ny });
				}
			}
		}
	}

}

int main() {

	cin >> M>>N>>H;

	//토마토 넣는 로직 
	for (int k = 0; k < H; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cin >> tomato[k][i][j];
				if (tomato[k][i][j]==1) { //익은 토마토가 존재하면 q에 push
					q.push({ { k,i }, j });
				}
				if (tomato[k][i][j] == 0) { //안익은 토마토 존재하면 visited -1 (가중치)
					visited[k][i][j] = -1;
				}
			}
		}
	}
	
	bfs();


	for (int k = 0; k < H; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[k][i][j] == -1) { //하나라도 안익었으면 -1 출력
					cout << -1;
					return 0;
				}
				result = max(result, visited[k][i][j]);
			}
		}
	}

	cout << result;



}