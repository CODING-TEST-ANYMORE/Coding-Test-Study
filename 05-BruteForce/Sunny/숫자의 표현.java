package Programmers;
// 프로그래머스 - 숫자의 표현
import java.util.*;
public class Solution_008 {
    public static int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            int j = i;
            while (sum < n && j < n) {
                sum += j;
                if (sum > n) break;
                j++;
            }
            if (sum == n) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int ans = solution(15);
        System.out.println(ans);
    }
}
