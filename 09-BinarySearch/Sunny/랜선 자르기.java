package Baekjoon;
// 백준 1654번 - 랜선 자르기
import java.util.*;
import java.io.*;
public class Solution_1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lan = new int[k];
        long max = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (max < lan[i]) max = lan[i];
            if (min > lan[i]) min = lan[i];
        }

        long left = max / n;
        long right = max + 1;
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            // 랜선 길이 mid일 때 나오는 케이블 수
            long cables = 0;
            for (int i = 0; i < k; i++) {
                cables += (lan[i] / mid);
            }

            if (cables < n) { // 케이블이 필요 이하로 나옴 !! -> 랜선 길이 줄여야 겠다!
                right = mid;
            } else { // 랜선 길이 늘려도 되겠다
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}
