//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/28.
//

#include <iostream>
//#include <algorithm>
//#include <vector>
//#include <stack>
//#include <string.h>
//#include <string>
//#include <queue>
#include <set>

using namespace std;

int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(0);cin.tie(0);

    int T,k;
    char c; int res;
    cin >> T;
    
    //multiset 이라는 개념을 처음 알았다.
    //multiset 은 set에서 중복을 허용하는 범위로 확장된 것이다.
    multiset<int> q;
    for(int i=0;i<T;i++){
        cin >> k;
        q.clear();
        
        for(int j=0;j<k;j++){
            cin >> c >> res;
            
            if(c == 'I'){
                q.insert(res);
            }
            else if(c == 'D'){
                if(q.empty()) continue; //비었을 때 예외값 처리
    
                if(res == 1){
                    auto max = q.end();
                    //max 가 끝값을 가리키기 때문에 수 자체는 가장 끝에서 바로 앞에 위치한다.
                    max--;
                    q.erase(max);
                }
                else if(res == -1) q.erase(q.begin());
            }
        }
        
        //자꾸만! 에러가 떴다. 그 이유가 알고보니 최소한의 ‘*’만을 사용해야 하기 때문이었다..
        //아래 코드의 위치만 바꿔줘도 성공이라니,,,
        //auto max = q.end(); max--;
        if(q.empty()) cout << "EMPTY" << "\n";
        else{
            auto max = q.end(); max--;
            //end, begin 을 나타낼 때 주소값을 나타내기 때문에 으로 표현해야 한다.
            cout << *max << " " << *q.begin() << "\n";
        }
        
    }
    
    return 0;
}
