package Baekjoon;
// 백준 10816번 - 숫자 카드2 (이분 탐색 이용)
import java.util.*;
import java.io.*;
public class Solution_10816_2 {
    public static int N;
    public static int M;
    public static int[] arr;

    public static int solution(int target) {
        int left = 0;
        int right = N - 1;

        while(left <= right && left > 0 && right < N) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        int endIdx = 0;
        if (arr[right] != target && arr[right - 1] != target)
            return 0;
        else {
            if (arr[right] == target) endIdx = right;
            else endIdx = right - 1;
        }

        left = 0;
        right = N - 1;
        while (left <= right && left > 0 && right < N) {
            int mid = (left + right) / 2;
            if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        int startIdx = 0;
        if (arr[left] == target) startIdx = left;
        else startIdx = left + 1;

        return endIdx - startIdx + 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bw.write(solution(Integer.parseInt(st.nextToken())) + " ");
        }
        br.close();
        bw.close();
    }
}
