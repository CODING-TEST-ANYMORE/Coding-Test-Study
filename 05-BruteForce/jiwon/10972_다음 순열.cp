//
//  main.cpp
//  baekjoon
//
//  Created by 신지원 on 2023/05/12.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);cin.tie(0);
    
    int N;
    cin >> N;
    vector<int> v;
    for(int i=0;i<N;i++){
        int n;
        cin >> n;
        v.push_back(n);
    }
    
    //next_permutation 함수는 STL 로 다음 순열이 저장된다. 만약 다음순열이 없다면 false 를 반환한다.
    if(next_permutation(v.begin(),v.end())) {
        for(int i=0;i<N;i++) cout << v[i] << " ";
    }
    else cout << "-1";
    
    return 0;
}
