//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/09.
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
    
    int n, res=0;
    cin >> n;
    
    for(int i=0;i<n;i++){
        string s;
        cin >> s;
        stack<char> stack;

        
        for(int j=0;j<s.length();j++){
            
            if(stack.empty()) stack.push(s[j]);
            else{
                if(stack.top() == s[j]) stack.pop();
                else stack.push(s[j]);
            }
        }
        
        if(stack.empty()) res++;
    }
    
    cout << res << "\n";
    
    return 0;
}
