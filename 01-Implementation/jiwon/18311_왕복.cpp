//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/13.
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
    
    int n;
    long long k;
    cin >> n >> k;
    int list[n+1];
    
    list[0] = 0;
    for(int i=1;i<=n;i++){
        cin >> list[i];
    }
    
    int num=-1;
    while(k>=0){
        num++;
        if(num<=n) k -= list[num];
        else k -= list[2*n-num+1];
    }
    
    if(num<=n) cout << num << "\n";
    else cout << 2*n-num+1 << "\n";
    
    return 0;
}
