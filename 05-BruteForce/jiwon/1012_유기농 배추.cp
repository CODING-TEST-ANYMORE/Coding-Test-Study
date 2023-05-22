//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/05.
//

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

void bfs(int x,int y){
    visited[x][y] = true;
    q.push(make_pair(x, y));
    
    while(!q.empty()){
        x = q.front().first;
        y = q.front().second;
        q.pop();
        
        for(int i=0;i<4;i++){
            //범위안에 속한다면
            if(x+dx[i]>=0 && x+dx[i]<M && y+dy[i]>=0 && y+dy[i]<N){
                //그리고 방문하지 않은 곳에 배추가 있다면
                if(loc[x+dx[i]][y+dy[i]]&& !visited[x+dx[i]][y+dy[i]]){
                    //q에 push 하며 bfs 처리
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
        //초기화
        fill_n(&visited[0][0], M*N, false);
        fill_n(&loc[0][0], M*N, false);
    }
    
    return 0;
}
