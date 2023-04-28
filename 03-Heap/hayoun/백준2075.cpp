#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int main()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    priority_queue<int, vector<int>, greater<int>> q;
    for (int i = 0; i < N * N; i++)
    {
        int a;
        cin >> a;
        q.push(a);
        if (q.size() > N)
        {
            q.pop();
        }
    }
    cout << q.top();
}
