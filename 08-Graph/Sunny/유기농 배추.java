package Baekjoon;
// 백준 1012번 - 유기농 배추
import java.util.*;
public class Solution_1012 {
    public static int T; // 테스트 케이스 개수
    public static int M; // 배추밭 가로 길이
    public static int N; // 배추밭 새로 길이
    public static int K; // 배추 개수
    public static int[][] graph;
    public static int[][] visited;
    public static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    public static int[] dy = {0, 0, -1, 1};

    static boolean dfs(int x, int y, int[][] graph) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= N || y <= -1 || y >= M) return false;

        if (visited[x][y] == 0 && graph[x][y] == 1) { // 방문한 적 없고 배추가 있는 자리라면
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny, graph);
            }
            return true;
        }
        return false;
    }

    public static int cabbage(int n, int m, int[][] graph) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i, j, graph)) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            graph = new int[N][M];
            visited = new int[N][M];

            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[y][x] = 1;
            }
            list.add(cabbage(N, M, graph));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
