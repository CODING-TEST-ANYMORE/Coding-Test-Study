
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
        //���� ���� ���� K �̻��� ��� ����
        if (pq.top() >= K) {
            break;
        }
        //pq size�� 1�̸� ���̻� ������ �ص� ������ ���� �� ���� ������ -1 �� ����
        if (pq.size() == 1) {
            answer = -1;
            break;
        }

        answer++;

        //������ ���� ���� �״�� ����
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