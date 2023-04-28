//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/11.
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
    int T,n,m;
    cin >> T;
    
    //dp[2][2] = 1 // dp[2][3] = 1+2 //dp[2][4] = 1+2+ 3 //dp[2][5] = 1+2+3+4
    //dp[3][3] = 1 //dp[3][4] = 1+ 1+2 //dp[3][5] = 1+1+2 +
    for(int i=0;i<T;i++){
        int dp[31][31];
        cin >> n >> m;
        
        //d[n][m] = dp[n][m-1] + dp[n-1][m-1]
        for(int j=1;j<=m;j++){
            dp[1][j] = j;
        }
        for(int j=2;j<=n;j++){
            for(int k=j;k<=m;k++){
                if(j==k) dp[j][k] = 1;
                else{
                    dp[j][k] = dp[j][k-1] + dp[j-1][k-1];
                }
            }
        }
        
        cout << dp[n][m] << "\n";
        
    }
    
    return 0;
}
