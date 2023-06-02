package Baekjoon;
// 백준 7569번 - 토마토
import java.io.*;
import java.util.*;
public class Solution_7569 {
    public static int M;
    public static int N;
    public static int H;
    public static int[][][] map;
    public static Queue<Tomato> ripen = new LinkedList<>();
    public static int[] dx = {-1, 0, 1, 0, 0, 0};
    public static int[] dy = {0, 1, 0, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

   static class Tomato {
       int x;
       int y;
       int z;
       public Tomato(int x, int y, int z) {
           this.x = x;
           this.y = y;
           this.z = z;
       }
   }

   public static int bfs() {
       while (!ripen.isEmpty()){
           Tomato curr = ripen.poll();
           int x = curr.x;
           int y = curr.y;
           int z = curr.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (map[nz][nx][ny] != 0) continue;
                ripen.add(new Tomato(nx, ny, nz));
                map[nz][nx][ny] = map[z][x][y] + 1;
            }
       }
       // map에서 최댓값이 일수!
       int result = Integer.MIN_VALUE;
       for (int i = 0; i < H; i++) {
           for (int j = 0; j < N; j++) {
               for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return -1;
                    result = Math.max(result, map[i][j][k]);
               }
           }
       }
       if (result == 1) return 0;
       return result - 1;
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M]; // z, x, y

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) ripen.add(new Tomato(j, k, i));
                }
            }
        }
        System.out.println(bfs());
    }
}
