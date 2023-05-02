//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/04/25.
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
    cin >> n;
    vector<pair<pair<int, int>,pair<int,string>>> v(n);
    //pair 를 처음 써보았다!

    for(int i=0;i<n;i++){
        cin >> v[i].second.second >> v[i].second.first >> v[i].first.second >> v[i].first.first;
    }
        //first 와 second 로 첫번쨰, 두번째 인자에 접근 가능
    sort(v.begin(),v.end());
    cout << v[n-1].second.second << "\n" << v[0].second.second << "\n";
    
    return 0;
}
