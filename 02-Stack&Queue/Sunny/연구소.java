package Baekjoon;
// 백준 14502번 - 연구소
import java.util.*;
public class Solution_14502 {
    static int n, m;
    static int[][] map;
    static int answer = Integer.MIN_VALUE;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static class virus {
        int x;
        int y;
        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            bfs(); // 바이러스를 퍼뜨려서 안전공간 센다.
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) { // 빈 공간이라면
                    map[i][j] = 1; // 벽을 세운다.
                    dfs(depth + 1);
                    map[i][j] = 0; // 벽 다시 치운다.
                }
            }
        }
    }

    public static void bfs() {
        Queue<virus> vq = new LinkedList<>();
        // copy_map 만들기!!
        int[][] copy_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                copy_map[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    vq.add(new virus(i, j));
                }
            }
        }

        // 바이러스 퍼뜨리기 작업
        while (!vq.isEmpty()) {
            virus curr = vq.poll();
            int x = curr.x;
            int y = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copy_map[nx][ny] == 0) {
                        vq.add(new virus(nx, ny));
                        copy_map[nx][ny] = 2;
                    }
                }
            }
        }
        chkSafeZone(copy_map);
    }

    public static void chkSafeZone(int[][] copy_map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy_map[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc =  new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //
        dfs(0);
        System.out.println(answer);
    }
}
