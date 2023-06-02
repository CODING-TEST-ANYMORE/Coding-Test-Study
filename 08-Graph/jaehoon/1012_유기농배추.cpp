#include<iostream>
#include<cstring>
#include<vector>
using namespace std;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int T;
int M, N,K;
int a, b;
int graph[51][51] = { 0 }; //배추심은 곳을 표기한 배열
int visited[51][51] = { 0 }; // dfs활용시 방문여부 체크하는 배열

void dfs(  int startY,int startX ) {

	for (int i = 0; i < 4; i++) { //현재 좌표에서 상하좌우를 확인하는 for문
		int nx = startX + dx[i];
		int ny = startY + dy[i];
		
		if (nx >= 0 && ny >= 0 && nx < M && ny < N) { //좌표가 배열에서 벗어나는지 확인
			if (!visited[ny][nx] && graph[ny][nx] == 1) { //현재 좌표가 방문한 적이 없고, 배추가 심어져있으면 dfs함수 호출
				visited[ny][nx] = 1; 

				dfs(ny, nx); 
			}
		}
	}
}

int main() {

	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> M >> N >> K;
	
		//매 반복문마다 배열 초기화
		memset(visited, 0, sizeof(visited)); 
		memset(graph, 0, sizeof(graph));
		int count = 0;
		for (int j = 0; j < K; j++) {
			cin >> a >> b;
			graph[b][a] = 1;
		}

		//방문하지 않았고 배추가 심어져있으면 카운트를 한후 주변 배추를 검사하기 위해 dfs호출
		for (int l = 0; l < N; l++) {
			for (int k = 0; k < M; k++) {
				if (!visited[l][k] && graph[l][k] == 1) {
					count++;
					visited[l][k] = 1;
					dfs(l, k);
				}
			}
		}
		cout << count<<"\n";
	}

}