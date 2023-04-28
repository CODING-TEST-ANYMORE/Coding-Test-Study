
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;



int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>>pq;
    int answer = 0;
    int res = 0;
    for (int i = 0; i < scoville.size(); i++) {
        pq.push(scoville[i]);
    }


    while (1) {
        int first = 0, second = 0;
        //가장 작은 값이 K 이상일 경우 종료
        if (pq.top() >= K) {
            break;
        }
        //pq size가 1이면 더이상 연산을 해도 정답을 구할 수 없기 때문에 -1 후 종료
        if (pq.size() == 1) {
            answer = -1;
            break;
        }

        answer++;

        //문제에 나온 연산 그대로 진행
        if (!pq.empty()) {
            first = pq.top();
            pq.pop();
        }
        if (!pq.empty()) {
            second = pq.top() * 2;
            pq.pop();
        }
        res = first + second;
        if (res == 0) {
            answer = -1;
            break;
        }
        pq.push(res);


    }
    return answer;
}