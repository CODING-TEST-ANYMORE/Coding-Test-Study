#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>


#include <queue>
using namespace std;
//greater �ڷ����� �־ ���� ���ڰ� �켱������ ����
priority_queue<int,vector<int>,greater<int>> pq;
vector<vector<long long>>v;
vector<long long> v2;
int N;

int main() {
	//�Ʒ� �ΰ� �ȳ־��༭ �ð��ʰ��� �����µ� �ذ�
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr); 

	//ios_base::sync_with_stdio ������ c�� stdio�� cpp�� iostream�� ����ȭ�����ִ� ������ �ϴµ�, �� �� iostream�� stdio�� ���۸� ��� ����ϱ� ������ �����̰� �߻��մϴ�.
	//	����, ios_base::sync_with_stdio(false); �ڵ带 �ۼ��������ν� ����ȭ�� ��Ȱ��ȭ�����ݴϴ�.

	//�⺻������ cin���� ���� �� ���� ��� ���۸� ���µ�, ���������� �˰����� Ǯ ���� ȭ�鿡 �ٷ� ���̴� ���� �߿����� �ʽ��ϴ�.
	//����, �Է°� ����� ���� �� �����ư��� �ݺ��ؾ� �ϴ� ��� �ʼ������� cin.tie(null); �ڵ带 �߰��Ͽ� cout�� cin�� ������ Ǯ����� �մϴ�.

	long long num;
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> num;
			pq.push(num);

			//pq�� N���� Ŀ���� �޸� �ʰ��� �� �� �־ �������� pop����
			if (pq.size() > N) {
				pq.pop();
			}
		}
	}
		//�������� �켱������ size�� N�̱� ������ top�ϸ� N��°�� ū ��
		cout << pq.top();
	



	return 0;
}



