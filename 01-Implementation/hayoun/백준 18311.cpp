#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
long long N, K;

long long course[100001];

int main()
{

    cin >> N >> K;
    int num = 0;
    course[0] = 0;
    for (int i = 1; i <= N; i++)
    {
        int a;
        cin >> a;
        num = num + a;
        course[i] = num;
    }
    int z = 0;
    long long p = K / course[N];
    if (p % 2 == 0)
    {
        z = 0;
    }
    else
    {
        z = 1;
    }
    long long ans = 0;
    if (z == 1)
    {
        ans = K % course[N];
        ans = course[N] - ans;
    }
    else
    {
        ans = K % course[N];
    }

    for (int i = 0; i < N; i++)
    {
        if (course[N] == ans)
        {
            cout << N;
            break;
        }

        if (ans < course[i] && ans >= course[i - 1])
        {
            cout << i;
            break;
        }
    }
}