//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/01.
//

#include <iostream>
#include <queue>

using namespace std;
int N,M,V;

//dfs에 필요
int line[1001][1001];
bool visited[1001]; //false 로 초기화

//bfs에 필요
queue<int> q;

void DFS(int v){ //보통 DFS는 재귀 또는 스택을 이용하여 구현할 수 있다.
    visited[v] = true; //정점 v는 방문한 것으로 처리
    cout << v << " "; //출력
    
    for(int i=1;i<=N;i++) {
        if(line[v][i]==1 && !visited[i]) { //정점과 연결은 되어 있는데 방문하지 않았다면
            DFS(i); //다시 깊이탐색 //문제 조건에 맞게 i를 작은 것부터 큰 것으로
        }
    }
}

void BFS(int v){ //보통 BFS는 큐를 이용하여 구현한다.
    visited[v] = true; //정점 v는 방문한 것으로 처리
    q.push(v);
    cout << v << " ";
    
    while(!q.empty()){
        v = q.front(); //맨 앞을 v로 저장
        q.pop(); //처음: 방금 넣은 v 삭제 + for문으로 고려해준 것 삭제
        
        for(int i=0;i<=N;i++){
            if(line[v][i] == 1 && !visited[i]) { //정점과 연결은 되어 있는데 방문하지 않았다면
                q.push(i);
                visited[i] = true;
                cout << i << " ";
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);

    cin >> N >> M >> V;
    
    for(int i=0;i<M;i++){
        int start,end;
        cin >> start >> end;
        line[start][end] = 1;
        line[end][start] = 1;
    }
    
    DFS(V);
    cout << "\n";
    fill_n(visited, 1001, 0);
    BFS(V);
    
    return 0;
}
