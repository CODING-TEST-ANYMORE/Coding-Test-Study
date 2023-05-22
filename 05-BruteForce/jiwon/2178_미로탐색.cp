//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/11.
//

#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;
int n, k, dis[100][100];
int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,-1,1};
string m[100];

/*
 string으로 받아야하기 때문에 string 배열을 선언해하였다. 그리고 좌표를 설정해주어 해결 가능하다. 최소 거리를 구해야 하기 때문에 bfs를 사용하였다.
 */

void bfs(){
    queue<pair<int, int>> q;
    q.push({0,0});
    dis[0][0] = 1;
    while(!q.empty()){
        
        for(int i=0;i<4;i++){
            //pair 로 좌표 잡아주기
            int x = q.front().first+dx[i];
            int y = q.front().second+dy[i];
            
            //범위안에 있다면
            if(x>=0&&x<n&&y>=0&&y<k){
                //1이라면 방문, push 하여 bfs 고려, 다시 dis 조정
                if(m[x][y]=='1'){
                    m[x][y]='X'; //visited
                    q.push({x, y});
                    dis[x][y] = dis[q.front().first][q.front().second]+1;
                }
            }
        }
        q.pop();
    }
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(0);cin.tie(0);
    cin>>n>>k;
    for(int i=0;i<n;i++){
        cin>>m[i];
    }
    bfs();
    cout<<dis[n-1][k-1];
    return 0;
}
