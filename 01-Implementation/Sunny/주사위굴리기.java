// 백준 14499번 - 주사위 굴리기
import java.util.*;

public class Solution_14499 {
    // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    static int[] dx = {0, 0, -1, 1}; // X, 동, 서, 북, 남
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = {0, 0, 0, 0, 0, 0};

    public static void moveUp() {
        int[] temp = dice.clone();
        dice[0] = temp[1];
        dice[1] = temp[2];
        dice[2] = temp[3];
        dice[3] = temp[0];
    }

    public static void moveDown() {
        int[] temp = dice.clone();
        dice[0] = temp[3];
        dice[1] = temp[0];
        dice[2] = temp[1];
        dice[3] = temp[2];
    }

    public static void moveRight() {
        int[] temp = dice.clone();
        dice[1] = temp[4];
        dice[3] = temp[5];
        dice[4] = temp[3];
        dice[5] = temp[1];
    }

    public static void moveLeft() {
        int[] temp = dice.clone();
        dice[1] = temp[5];
        dice[3] = temp[4];
        dice[4] = temp[1];
        dice[5] = temp[3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        int x = sc.nextInt(); // 주사위 위치 (x)
        int y = sc.nextInt(); // 주사위 위치 (y)
        int k = sc.nextInt(); // 명령어 개수
        int[][] map = new int[n][m]; // 지도 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[] orders = new int[k];
        for (int i = 0; i < k; i++) {
            orders[i] = sc.nextInt();
        }

        for (int order: orders) {
            //
            int nx = x + dx[order - 1];
            int ny = y + dy[order - 1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            x = nx;
            y = ny;
            if (order == 1) { // 동
                moveRight();
            } else if (order == 2) { // 서
                moveLeft();
            } else if (order == 3) { // 북
                moveUp();
            } else if (order == 4) { // 남
                moveDown();
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[3];
            } else {
                dice[3] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[1]);

        }
    }
}