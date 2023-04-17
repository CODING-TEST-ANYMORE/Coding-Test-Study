//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/10.
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
    
    int T;
    cin >> T;
    
    for(int i=0;i<T;i++){
        string s;
        cin >> s;
        
        int xy[2] = {0, }; //x,y
        int maxx[4] = {0, }; //xmax,ymin,xmin,ymax;
        int dir = 0; //up, left, down, right;
        
        for(int i=0;i<s.length();i++){
            
            if(s[i] == 'L' || s[i] == 'R'){
                if(s[i] == 'L') dir = (dir+1) % 4;
                if(s[i] == 'R') dir = (dir+3) % 4;
            }
            
            if(s[i] == 'F'){
                if(dir == 0 || dir == 3) {
                    xy[dir%2]++;
                    maxx[dir] = max(maxx[dir],xy[dir%2]);
                }
                else {
                    xy[dir%2]--;
                    maxx[dir] = min(maxx[dir],xy[dir%2]);
                }
            }
            
            if(s[i] == 'B'){
                if(dir == 0 || dir == 3) {
                    xy[dir%2]--;
                    maxx[(dir+2)%4] = min(maxx[(dir+2)%4],xy[dir%2]);
                }
                else {
                    xy[dir%2]++;
                    maxx[(dir+2)%4] = max(maxx[(dir+2)%4],xy[dir%2]);
                }
            }
        }
        
        //maxx[4] = {0, }; //xmax,ymin,xmin,ymax;
        
        int res;
        res = (maxx[0]-maxx[2]) * (maxx[3]-maxx[1]);
        
        cout << res << "\n";
        
    }
    
    
}
