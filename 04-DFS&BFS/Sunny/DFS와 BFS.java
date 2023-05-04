package Baekjoon;
// 백준 1260번 - DFS와 BFS
import java.util.*;
public class Solution_1260 {
    public static int N;
    public static int M;
    public static int V;
    public static int[][] Graph = new int[1001][1001];

    public static void dfs (int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next = 1; next <= N; ++next) {
            if (!visited[next] && Graph[node][next] != 0) dfs(next, visited);
        }
    }
    public static void bfs (int node) {
        boolean[] visited = new boolean[1001];

        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int next = 1; next <= N; ++next) {
                if (!visited[next] && Graph[curr][next] != 0) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[v][u] = 1;
        }
        boolean[] visited = new boolean[1001];
        dfs(V, visited);
        System.out.println();
        bfs(V);
    }
}
