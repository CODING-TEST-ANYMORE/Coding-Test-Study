package Baekjoon;
// 백준 178282번 - 문자열 화폐
// [풀이 참고] 시간 초과가 나서 풀이 참고해서 풀었습니당...
import java.util.*;
public class Solution_17828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        if (X < N || N * 26 < X) {
            System.out.println("!");
        } else {
            sb.append("A".repeat(N));
            X -= N;

            for (int i = 0; i < N; i++) {
                int temp = Math.min(X, 25);
                sb.setCharAt(i, (char)(sb.charAt(i) + temp));
                X -= temp;
            }

            System.out.println(sb.reverse());
        }

    }
}
