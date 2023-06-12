package Baekjoon;
// 백준 11663번 - 선분 위의 점
import java.util.*;
import java.io.*;
public class Solution_11663 {
    public static int N; // 점의 개수
    public static int M; // 선분 개수
    public static int[] point;
    public static int binarySearch(int x, int y) {
        int left = 0;
        int right = N - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(point[mid] > y) right = mid - 1;
            else left = mid + 1;
        }
        int endIdx = right + 1;

        left = 0;
        right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(point[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        int startIdx = left;
        return endIdx - startIdx;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        point = new int[N];
        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(point); // 점들을 오름차순 정렬

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = binarySearch(x, y);
            bw.write(result+"\n");
        }
        br.close();
        bw.close();
    }
}
