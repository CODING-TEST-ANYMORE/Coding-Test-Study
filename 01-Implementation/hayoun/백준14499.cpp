#include <iostream>
#include <vector>

#define endl "\n"
#define MAX 20
using namespace std;

int N, M, Sx, Sy, K;
int MAP[MAX][MAX];

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int Dice[7] = {0};

vector<int> Cmd;

void Input()
{
    cin >> N >> M >> Sx >> Sy >> K;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> MAP[i][j];
        }
    }
    for (int i = 0; i < K; i++)
    {
        int a;
        cin >> a;
        a = a - 1;
        Cmd.push_back(a);
    }
}

void RollTheDice(int d)
{
    int d1, d2, d3, d4, d5, d6;
    d1 = Dice[1], d2 = Dice[2], d3 = Dice[3];
    d4 = Dice[4], d5 = Dice[5], d6 = Dice[6];

    if (d == 0)
    {
        Dice[1] = d4;
        Dice[4] = d6;
        Dice[6] = d3;
        Dice[3] = d1;
    }
    else if (d == 1)
    {
        Dice[4] = d1;
        Dice[6] = d4;
        Dice[3] = d6;
        Dice[1] = d3;
    }
    else if (d == 2)
    {
        Dice[1] = d5;
        Dice[2] = d1;
        Dice[6] = d2;
        Dice[5] = d6;
    }
    else if (d == 3)
    {
        Dice[5] = d1;
        Dice[1] = d2;
        Dice[2] = d6;
        Dice[6] = d5;
    }
}

void Solve()
{
    int x = Sx;
    int y = Sy;

    for (int i = 0; i < Cmd.size(); i++)
    {
        int nx = x + dx[Cmd.at(i)];
        int ny = y + dy[Cmd.at(i)];
        int d = Cmd.at(i);

        if (nx < 0 || ny < 0 || nx >= N || ny >= M)
            continue;

        RollTheDice(d);
        if (MAP[nx][ny] == 0)
            MAP[nx][ny] = Dice[6];
        else
        {
            Dice[6] = MAP[nx][ny];
            MAP[nx][ny] = 0;
        }

        cout << Dice[1] << endl;

        x = nx;
        y = ny;
    }
}

int main(void)
{
    Input();
    Solve();

    return 0;
}
