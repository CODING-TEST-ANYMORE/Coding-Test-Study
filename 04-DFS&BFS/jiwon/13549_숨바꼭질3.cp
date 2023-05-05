//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/02.
//

#include <iostream>
//#include <algorithm>
//#include <vector>
//#include <stack>
//#include <string.h>
//#include <string>
#include <queue>

using namespace std;
int num[100001];
bool visited[100001]; //false 로 초기화
queue<int> q;
int N,K;

void BFS(int N){
    q.push(N);
    visited[N] = true;
    num[N] = 0;
    int n = N;
    
    while(n!=K){
        q.pop();
        
                //2n을 먼저 고려해야 함
        if(!visited[2*n] && 2*n<100001){
            q.push(2*n);
            visited[2*n] = true;
            num[2*n] = num[n]; //0초로 변화한 것을 반영해야 함
        }
        if(!visited[n-1] && n-1>=0 ){
            q.push(n-1);
            visited[n-1] = true;
            num[n-1] = num[n] + 1;
        }
        if(!visited[n+1] && n+1<100001){
            q.push(n+1);
            visited[n+1] = true;
            num[n+1] = num[n] + 1;
        }
        
        n = q.front();
        
    }
    
}

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);

    cin >> N >> K;
    BFS(N);
    cout << num[K] << "\n";
    
    return 0;
}
