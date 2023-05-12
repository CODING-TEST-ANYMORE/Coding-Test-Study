package Baekjoon;
// 백준 9095 - 1, 2, 3 더하기
import java.util.*;

public class Solution_9095 {
    public static int T;
    public static int[] answer;

    public static void solution(int sum, int target, int t) {
        if (sum >= target) {
            if (sum == target) answer[t]++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int tmp = sum + i;
            solution(tmp, target, t);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        answer = new int[T];

        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            solution(0, x, i);
        }

        for (int i = 0; i < T; i++)
            System.out.println(answer[i]);
    }
}
