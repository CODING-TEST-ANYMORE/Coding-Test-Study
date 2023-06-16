#include <iostream>
#define INF 1e9
#define MAX 101
using namespace std;

int n, m; // 노드, 간선 개수 
int dist[MAX][MAX]; // 두 노드 간의 비용을 저장하는 2차원 배열 

void input() {
	cin >> n >> m;

    // 최단 거리 테이블 초기화
    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            if (i == j) dist[i][j] = 0;
            else dist[i][j] = INF;
        }
    }

    // A에서 B로 가는 비용은 C라고 설정
    int a, b, c;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;

        // 동일한 간선이 또 입력될 경우, 비용이 더 작은 값으로 초기화!!!
        if (dist[a][b] > c) dist[a][b] = c;
    }
}

void floyd() {
	// 점화식에 따라 플로이드 워셜 알고리즘 수행
    for (int k = 1; k <= n; k++) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 자기 자신에서 자기 자신으로 가는 경로는 제외
                if (a == b) continue;
				
                // 경유하는 k번 노드는 출발, 도착 노드에서 제외
                if (k == a || k == b) continue;

                dist[a][b] = min(dist[a][b], dist[a][k] + dist[k][b]);
            }
        }
    }
}

void printResult() {
 	for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            if (dist[a][b] == INF) cout << 0 << ' '; 
            else cout << dist[a][b] << ' ';
        }
        cout << '\n';
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

	input(); 

	floyd();

	printResult();

	return 0; 
}
