#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>
#include <sstream>
#include <stack>
#include <queue>
using namespace std;

#define MAX 100001

int n, k;
int mapArr[MAX];
bool visited[MAX];


void bfs(int a)
{
	queue<pair<int, int>>q;	
	q.push(make_pair(a, 0));	
	visited[a] = true;	//�湮ǥ��

	while (!q.empty())
	{
		int x = q.front().first;	//queue�� front �� ����
		int cnt = q.front().second;

		q.pop();	

		visited[x] = true;	//�湮ǥ��

		if (mapArr[x] == 1)	//map�� �ش� �ε����� ���� 1�̶�� �ð������ ����
		{
			cout << cnt;
			break;
		}

		if (x + 1 >= 0 && x + 1 < MAX && !visited[x + 1])	
			q.push(make_pair(x + 1, cnt + 1));	//x+1�� �ð� ������ push

		if (x - 1 >= 0 && x - 1 < MAX && !visited[x - 1])
			q.push(make_pair(x - 1, cnt + 1));

		if (x * 2 >= 0 && x * 2 < MAX && !visited[x * 2])
			q.push(make_pair(x * 2, cnt + 1));

	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;	
	mapArr[k] = 1;	
	bfs(n);	

	return 0;
}