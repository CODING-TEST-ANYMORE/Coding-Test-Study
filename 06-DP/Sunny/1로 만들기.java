package Baekjoon;
// 백준 1463번 - 1로 만들기
import java.util.*;
public class Solution_1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1]; // dp[i] -> 정수가 i를 1로 만들 때의 연산횟수 최솟값

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            // 1. 1 빼주기
            dp[i] = dp[i - 1] + 1;
            // 2. 2로 나누기
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            // 3. 3으로 나누기
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[N]);
    }
}
