//
//  23304_아카라카.cpp
//
//  Created by 신지원 on 2023/06/01.
//
//한동안 문제 자체가 헷갈려서 못풀었던 문젠데 풀었씁니당,, 헤헤

#include <iostream>
#include <algorithm>

using namespace std;

int aka(string s, int end){
    
    int i = 0;

    while( i < (end-1-i)){
        //cout << i << " " << end << " " << "\n";
        //cout << s[i] << " " << s[end-1-i] << "\n";
        
        if(s[i] != s[end-1-i]) return 0;
        i++;
    }
    return 1;
    
}

int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(0);cin.tie(0);
    
    string s;
    cin >> s;
    int n = s.size();
    int end = n;
    
    //팰린드롬이 되는 경우를 끊어서 다시 팰린드롬을 확인해주었습니다.
    //재귀 같은 형식!
    while(end>2){
        if(aka(s,end) == 0){
            cout << "IPSELENTI" << "\n";
            return 0;
        }
        end = end/2;
    }
    
    cout << "AKARAKA" << "\n";
    return 0;
}
