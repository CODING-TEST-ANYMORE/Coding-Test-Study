package Baekjoon;
// 백준 3079번 - 입국 심사
// 원래는 다른 방식으로 풀었으나 시간 초과 해결을 못해서 풀이 참조하여 풀었습니다 ㅠ^ㅠ
import java.util.*;
import java.io.*;
public class Solution_3079_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cp = new int[N];

        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            cp[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, cp[i]);
        }

        long high = maxTime * M; // 최대 시간
        long low = 0;

        while (low < high) {
            long mid = (low + high) / 2;
            int required = 0; // 통과하는 승객 수

            for (int e: cp) {
                required += mid / e;
            }

            if (required < M)
                low = mid + 1;
            else high = mid;
        }

        System.out.println(high);
    }
}
