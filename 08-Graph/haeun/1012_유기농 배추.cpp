#include <iostream> 
#include <vector> 
#include <string>
#include <algorithm>
#include <cstring> 
using namespace std;

const int MAX = 51;
int m, n, k; // m(가로, 열) n(세로, 행) 
int graph[MAX][MAX];
bool visited[MAX][MAX]; 

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void input() {
	cin >> m >> n >> k; 

	// 가로는 열, 세로는 행 
	for(int i = 0; i < k; i++){
		int c, r; 
		cin >> c >> r; 
		graph[r][c] = 1; // 배열 인덱스 순서 주의!!  
	}
}

void dfs(int x, int y){ 
	visited[x][y] = true; 

	for(int i = 0; i < 4; i++){
		int nx = x + dx[i];
		int ny = y + dy[i];

		if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; 

		if(graph[nx][ny] == 1 && !visited[nx][ny]){ 
			dfs(nx, ny);
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
    cin.tie(0);

	int t;
	cin >> t;

	while(t--){
		input();

		int cnt = 0; 
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){ 
				if(graph[i][j] == 1 && !visited[i][j]){
					cnt++; 
					dfs(i, j); 
				}
			}
		}

		cout << cnt << endl;

		memset(visited, 0, sizeof(visited)); 
		memset(graph, 0, sizeof(graph)); 
	}
	
	return 0;
}
