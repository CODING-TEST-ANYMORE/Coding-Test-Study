//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/10.
//

#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);
    
    int T;
    cin >> T;
    
    int dp[11];
    dp[1] = 1; //1
    dp[2] = 1+1; //2
    dp[3] = 1+2+1; //4
    //dp[4] = 1+3+(1+2) = 7
    //dp[5] = 1+4+3+3+2 = 13
    
    for(int i=0;i<T;i++){
        int n;
        cin >> n;
        
        for(int j=4;j<=n;j++){
            dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
            //위에서 계산한 바를 통해 점화식을 도출하였다.
        }
        cout << dp[n] << "\n";
    }
    
    return 0;
}
