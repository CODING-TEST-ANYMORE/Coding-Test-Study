//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/02.
//

#include <iostream>
#include <queue>

using namespace std;
int num[100001];
bool visited[100001]; //false 로 초기화
queue<int> q;
int N,K;

/*dp로 풀면 안되나? 생각했지만 수가 쌓여 관련은 있지만
 1. 차례로 규칙성을 보이지 않고
 2. 방문을 고려해줘야 하기 때문에
 bfs 가 적절한 해결방법이었다.
 n-1,n+1,2n 모두 다 넣고 순서대로 고려해주며 K를 찾아내면 된다!
 */

void BFS(int N){
    //처음 N에 대한 설정
    q.push(N);
    visited[N] = true;
    num[N] = 0;
    int n = N;
    
    while(n!=K){
        q.pop();
        
        //조건에 해당할 시, push + 방문 + 값 설정
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
        if(!visited[2*n] && 2*n<100001){
            q.push(2*n);
            visited[2*n] = true;
            num[2*n] = num[n] + 1;
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
