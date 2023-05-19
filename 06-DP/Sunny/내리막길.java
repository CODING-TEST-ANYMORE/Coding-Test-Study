package Baekjoon;
// 백준 1520번 - 내리막길
// 어려워서 풀이참고해서 풀었습니당...!
import java.util.*;
public class Solution_1520 {
    public static int N, M;
    public static int[][] map;
    public static int[][] dp;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        if (x == N - 1 && y == M - 1)
            return;

        if (visited[x][y])
            return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if (map[x][y] > map[nx][ny]) {
                if (dp[nx][ny] != 0) {
                    dp[x][y] += dp[nx][ny];
                    continue;
                } else {
                    dfs(nx, ny);
                    dp[x][y] += dp[nx][ny];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //
        dp = new int[N][M];
        visited = new boolean[N][M];
        dp[N - 1][M - 1] = 1;
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }
}
