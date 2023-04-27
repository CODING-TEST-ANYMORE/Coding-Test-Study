#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>> pq; // 최소 힙
    
    for(int i = 0; i < scoville.size(); i++){
        pq.push(scoville[i]); 
    }
    
    // 가장 작은 원소가 K 이상이 될 때까지
    int cnt = 0;
    while(pq.top() < K){
        if(pq.size() == 1){
            return -1; 
        }
        
        int first = pq.top();
        pq.pop(); 
        int second = pq.top();
        pq.pop();
        
        int newScoville = first + second * 2;
        pq.push(newScoville);
        
        cnt++;
    }
    
    return cnt; 
}