//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/06/02.
//
// 전형적인 bfs 문제로 풀었다. 다만 계속해서 답이 맞지 않아 이유를 살펴보니 초기화 해주는 과정에서
// fill_n 함수를 사용하였는데, 여기에 문제가 있었다. 따로 reset() 함수를 선언해주어 해결할 수 있었다.

#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <string.h>
#include <string>
#include <queue>

using namespace std;
bool loc[51][51];
bool visited[51][51];
int dx[4] = {-1,1,0,0}; //좌우
int dy[4] = {0,0,1,-1}; //상하
queue<pair<int,int>> q;
int T,M,N,K;

void reset() {
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            loc[i][j] = false;
        }
    }
    
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            visited[i][j] = false;
        }
    }
}

void bfs(int x,int y){
    visited[x][y] = true;
    q.push(make_pair(x, y));
    
    while(!q.empty()){
        x = q.front().first;
        y = q.front().second;
        q.pop();
        
        for(int i=0;i<4;i++){
            if(x+dx[i]>=0 && x+dx[i]<M && y+dy[i]>=0 && y+dy[i]<N){
                if(loc[x+dx[i]][y+dy[i]]&& !visited[x+dx[i]][y+dy[i]]){
                    q.push(make_pair(x+dx[i], y+dy[i]));
                    visited[x+dx[i]][y+dy[i]] = true;
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);
    
    cin >> T;
    for(int i=0;i<T;i++){
        cin >> M >> N >> K;
        
        reset();
        
        for(int j=1;j<=K;j++){
            int X,Y;
            cin >> X >> Y;
            loc[X][Y] = true;
        }
        
        int num = 0;
        for(int j=0;j<M;j++){
            for(int k=0;k<N;k++){
                if(loc[j][k] && !visited[j][k]){
                    bfs(j, k);
                    num++;
                    
                }
            }
        }
        
        cout << num << "\n";
//        fill_n(&visited[0][0], M*N, false);
//        fill_n(&loc[0][0], M*N, false);
    }
    
    return 0;
}

