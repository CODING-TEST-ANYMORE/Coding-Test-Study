//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/24.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <string.h>
#include <string>
#include <queue>

using namespace std;
int N;
void change(int x, int y, int n){
    //if(n==1) return;
    if((x/n)%3 == 1 && (y/n)%3 ==1) cout << " ";
    else{
        if(n/3 == 0) cout << "*";
        else change(x,y,n/3);
    } // 재귀적으로 구현하였습니다!
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(0);cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++) change(i,j,N);
        cout<<"\n";
    }
    return 0;
}
