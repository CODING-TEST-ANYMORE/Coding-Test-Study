package Baekjoon;
// 백준 16236번 - 아기 상어
/*
* [실패 & 푸는 중...]
* bfs로 먹이 찾아서 이동하다가
* 물고기 먹고 나면 bfs 초기화하고 다시 먹이 찾아 다닌다..!
* 근데 조건 충족이 잘 안되는 것 같아서.. 좀만 더 해보던가 아니면 다른 풀이 참고해서 더 풀 생각입니다ㅜ
* */
import java.util.*;
public class Solution_16236 {
    public static int N;
    public static int[][] map;
    public static int size = 2; // 상어의 크기
    public static int ate; // 상어가 먹은 양
    public static int[] dx = {-1, 0, 1, 0}; // 상, 좌, 하, 우
    public static int[] dy = {0, -1, 0, 1};
    public static int answer;

    static class Location {
        int x;
        int y;
        Location (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(Location loc) {
        boolean[][] visited = new boolean[N][N];
        int[][] timeMap = new int[N][N];

        Queue<Location> q = new LinkedList<>();
        q.offer(loc);
        visited[loc.x][loc.y] = true;
        map[loc.x][loc.y] = 0; // 상어가 있던 자리 빈칸으로 만들어줌

        while (!q.isEmpty()) {
            Location curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] > size || visited[nx][ny]) continue;
                // 그냥 이동만할 것인지 OR 먹을 것인지
                timeMap[nx][ny] = timeMap[curr.x][curr.y] + 1;
                // 1. 이동
                if (map[nx][ny] == 0 || map[nx][ny] == size) {
                    visited[nx][ny] = true;
                    q.offer(new Location(nx, ny));
                    continue;
                }
                // 2. 먹음
                if (map[nx][ny] < size) {
                    answer = timeMap[nx][ny];
                    System.out.println("먹었다? -> "+answer+", ("+nx+", "+ny +"), size: " + map[nx][ny]);
                    ate ++; // 먹음
                    q.clear();
                    map[nx][ny] = 0; // 먹힌 물고기 자리 비워주기
                    if (ate == size) { // 상어가 커질 때가 됐는지 체크
                        System.out.println("커진다!! ->" + size);
                        size++;
                        ate = 0;
                    }
                    for (int l = 0; l < N; l++) { // 방문 초기화
                        for (int m = 0; m < N; m++) {
                            visited[l][m] = false;
                            timeMap[l][m] = 0;
                        }
                    }
                    timeMap[nx][ny] = answer;
                    visited[nx][ny] = true;
                    q.offer(new Location(nx, ny));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = sc.nextInt();
                map[i][j] = k;
                if (map[i][j] == 9) { // 상어 시작 위치
                    x = i;
                    y = j;
                }
            }
        }
        bfs(new Location(x, y));
        System.out.println(answer);
    }
}
