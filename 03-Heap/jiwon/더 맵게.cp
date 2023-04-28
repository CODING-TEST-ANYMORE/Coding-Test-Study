#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> scoville, int K) {
    //오름차순으로 정렬
    sort(scoville.begin(), scoville.end());
    
    int answer = 0, res = scoville[0], i=0;
    
    //IDEA
    //scoville 리스트 중에서 K보다 큰 i번째 원소가 있는 지 확인
    //만약 있다면, 지금까지 섞은 음식의 값을 확인하여 K와 같거나 크면 섞은 횟수는 i-1 OR K보다 작다면 i번째 원소까지 더해줘야 하기 때문에 섞은 횟수는 i
    //만약 없다면, 원소를 모두 다 했을 때 값(res)가 K와 같거나 크면 섞은 횟수는 원소 개수 -1, 아니면 -1 리턴
    
    if(scoville[0] < K){
        //scoville 원소에서 K보다 크거나 같은 원소 있는 지 확인
        while(scoville[i] < K && i < scoville.size()){
            res += scoville[i] * 2; //섞은 값 체크
            i++; //횟수가 scoville 의 사이즈 넘지 않는지 확인
        }
        
        if(i >= scoville.size()){ //만약 다 돌 동안 큰 것을 못찾았다면,
            if(res < K) answer = -1; //섞은 값이 K보다 작다면 -1
            else answer = i-1; //크다면 (현재 i의 값인)원소size-1
        }
        else if(scoville[i] >= K){ //만약 scoville 원소 중에 K보다 큰 것을 발견했다면
            if(res < K) answer = i; //지금까지 섞은 값이 K보다 작다면, i번쨰도 섞어야 하니까 i 리턴
            else answer = i-1; // K보다 크다면, i번째를 섞을 필요 없으니까 i-1 리턴
        }
    }
    
    return answer;
}
