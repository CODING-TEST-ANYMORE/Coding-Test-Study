//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/04.
//

#include <iostream>
#include <stack>
#include <queue>

using namespace std;

queue<int> q;
vector<int> vec;
int num[100001];
bool visited[100001];
int res[100001];
int loc[100001];
int N,K,n;

/* 경로를 출력해야 하기 때문에 다음 차례에 미리 이번 경로를 넣어주고, 출력시 반대로 출력한다.
따라서 5 10 9 18 17 의 순서일때, loc[10]에 5를, loc[9]에 10을, loc[18]에 9를, loc[17]에 18을 넣어주면
출력할 때는 index = 17 일 때, loc[index] 하여 18을 뽑아주면 된다 */

void BFS(int N){
    q.push(N);
    visited[N] = true;
    num[N] = 0;
    loc[n] = 0;
    int n = N;
    
    while(n!=K){
        q.pop();
        
        if(!visited[2*n] && 2*n<100001){
            q.push(2*n);
            visited[2*n] = true;
            num[2*n] = num[n] + 1;
            loc[2*n] = n;
        }
        if(!visited[n-1] && n-1>=0 ){
            q.push(n-1);
            visited[n-1] = true;
            num[n-1] = num[n] + 1;
            loc[n-1] = n;
        }
        if(!visited[n+1] && n+1<100001){
            q.push(n+1);
            visited[n+1] = true;
            num[n+1] = num[n] + 1;
            loc[n+1] = n;
        }
        
        n = q.front();
        
    }
    
}

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);
    
    cin >> N >> K;
    BFS(N);
    cout << num[K] << "\n";
    int k = K;
    while (k != N) {
        vec.push_back(loc[k]);
        k = loc[k];
    }
    for(int i = vec.size()-1; i >= 0; i--) cout << vec[i] << " ";
    cout << K << "\n";
    
    return 0;
}
