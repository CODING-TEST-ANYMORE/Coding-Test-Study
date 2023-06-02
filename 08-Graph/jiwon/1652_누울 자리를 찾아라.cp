//
//  1652_누울 자리를 찾아라.cpp
//
//  Created by 신지원 on 2023/05/31.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <string.h>
#include <string>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);
    
    int N;
    cin >> N;
    char room[N][N];
    int wid=0,len=0;
    
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin >> room[i][j];
        }
    }
    
    //가로로 누울 수 있는 자리 체크
    for(int i=0;i<N;i++){
        int num = 0;
        for(int j=0;j<N;j++){
            if(room[i][j] == '.') num++;
            else num=0;
            
            //연속으로 두 곳이 '.'이면 개수++; 그 이후엔 더 길어도 개수에 반영X, 대신 막혔었다면 다시 두 곳이 연속일 때 개수 ++
            if(num == 2) wid++;
        }
    }
    
    //세로로 누울 수 있는 자리 체크
    for(int j=0;j<N;j++){
        int num = 0;
        for(int i=0;i<N;i++){
            if(room[i][j] == '.') num++;
            else num=0;
            
            if(num == 2) len++;
        }
    }
    
    cout << wid << " " << len << "\n";
    
    return 0;
}
