// 백준 8911번 - 거북이
import java.util.*;
public class Solution_8911 {
    static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int[] dy = {1, 0, -1, 0};
    public static int solution(char[] arr) {
        int currRotation = 0; // 시작할 땐 북쪽을 바라보고 있음
        int maxX = 0, minX = 0, maxY = 0, minY = 0; // 거북이가 찍은 최대 (최소) x, y 좌표
        int x = 0;
        int y = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'F') {
                x += dx[currRotation];
                y += dy[currRotation];
            } else if (arr[i] == 'B') {
                x += dx[(currRotation + 2) % 4]; // 방향은 안 바꾸고 뒤로 back
                y += dy[(currRotation + 2) % 4];
            } else if (arr[i] == 'L') {
                if (currRotation == 0) // 북쪽 바라보고 있었다면 서쪽 보도록
                    currRotation = 3;
                else
                    currRotation--;
            } else { // if arr[i] == 'R'
                if (currRotation == 3) // 서쪽 바라보고 있었다면 북쪽 보도록
                    currRotation = 0;
                else
                    currRotation++;
            }
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
        }

        return Math.abs(maxX - minX) * Math.abs(maxY - minY);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 개수
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            arr[i] = str.toCharArray();
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = solution(arr[i]);
        }

        for (int ans: answer)
            System.out.println(ans);
    }
}
