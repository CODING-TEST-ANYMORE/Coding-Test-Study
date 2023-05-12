#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <queue>
#include <memory.h>
#define  ll long long
using namespace std;
bool visited[10001];
vector<int> adj[10001];
queue<int> q;
int N, M, V;
void bfs(int now)
{
	visited[now] = 1;
	q.push(now);

	while (!q.empty()) {
		int n = q.front();
		q.pop();
		cout << n << " ";

		for (int i = 0; i < adj[n].size(); i++) {
			int next = adj[n][i];
			if (!visited[next]) {
				visited[next] = 1;
				q.push(next);
			}
		}
	}
}

void dfs(int now)
{
	visited[now] = 1;
	cout << now << " ";

	for (int i = 0; i < adj[now].size(); i++)
	{

		if (!visited[adj[now][i]])
		{
			dfs(adj[now][i]);
		}
	}
}

int main()
{
	int a, b;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	for (int index = 0; index <= N; index++)
	{
		if (adj[index].size() > 1) sort(adj[index].begin(), adj[index].end());
	}

	dfs(V);
	memset(visited, 0, 10001 * sizeof(bool));
	cout << endl;
	bfs(V);



	return 0;
}