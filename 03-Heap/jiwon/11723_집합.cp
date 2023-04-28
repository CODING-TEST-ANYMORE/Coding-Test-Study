//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/27.
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

    int M,n;
    int x[21] = {0, };
    string str = "";
    cin >> M;
    for(int i=0;i<M;i++){
        cin >> str;
        
        if(str == "add"){
            cin >> n;
            if(x[n] == 0) x[n]=1;
        }
        else if(str == "remove"){
            cin >> n;
            if(x[n] == 1) x[n]=0;
        }
        else if(str == "check"){
            cin >> n;
            if(x[n] == 0) cout << "0" << "\n";
            else cout << "1" << "\n";
        }
        else if(str == "toggle"){
            cin >> n;
            if(x[n] == 0) x[n] = 1;
            else x[n]=0;
        }
        else if(str == "all"){
            for(int j=1;j<21;j++){
                x[j]=1;
            }
        }
        else if(str == "empty"){
            for(int j=1;j<21;j++){
                x[j]=0;
            }
        }
    }
    
    
    return 0;
}
