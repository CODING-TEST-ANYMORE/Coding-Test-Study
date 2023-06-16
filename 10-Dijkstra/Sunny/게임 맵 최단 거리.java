package Programmers;
import java.util.*;
import java.awt.Point;
// 프로그래머스 - 게임 맴 최단거리
public class Main {
    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void bfs (int[][] maps, int node1, int node2) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<Point> queue = new LinkedList<Point>();
        visited[node1][node2] = true;
        queue.add(new Point(node1, node2));

        while (!queue.isEmpty()) {
            Point curr = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx <= -1 || nx >= maps.length || ny <= -1 || ny >= maps[0].length)
                    continue;
                if (maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    maps[nx][ny] = maps[curr.x][curr.y] + 1;
                }
            }
        }
    }

    public static int solution(int[][] maps) {
        bfs(maps, 0, 0);
        int answer = maps[maps.length - 1][maps[0].length - 1];
        if (answer == 1) return -1;
        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1}, {1,1,1,0,0},{0,0,0,0,1}};
        int ans = solution(maps);
        System.out.println(ans);
    }
}
