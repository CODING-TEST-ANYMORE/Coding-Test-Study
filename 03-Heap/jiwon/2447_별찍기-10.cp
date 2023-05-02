//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/26.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <string.h>
#include <string>
#include <queue>

using namespace std;

int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(0);cin.tie(0);

    //이문제로 우선순위 큐 처음 알게 되어서 공부하고 풀어봤는데 꽤 괜찮더군요!!
    //간단해서 따로 주석은 달지 않을게요~!
    priority_queue<int,vector<int>,greater<int>> pq;
    int N,n;
    
    cin >> N;
    for(int i=0;i<N*N;i++){
        cin >> n;
        pq.push(n);
        if(pq.size()>N) pq.pop();
    }
    
    cout << pq.top() << "\n";

    return 0;
}
