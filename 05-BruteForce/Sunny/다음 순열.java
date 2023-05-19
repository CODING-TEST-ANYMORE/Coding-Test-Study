package Baekjoon;
// 백준 10972번 - 다음 순열
import java.util.*;
public class Solution_10972 {
    public static void solution (int[] arr, int n) {
        int idx = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) idx = i;
        }

        if (idx == -1) {
            System.out.println(-1);
            return;
        }
        int idx2 = -1;
        for (int i = idx; i < n; i++) {
            if (arr[idx - 1] < arr[i]) idx2 = i;
        }

        // arr[idx - 1], arr[idx2] swap!
        int tmp = arr[idx - 1];
        arr[idx - 1] = arr[idx2];
        arr[idx2] = tmp;

        // arr[idx]부터 순열 뒤집기
        int[] sub = new int[n - idx];
        for (int i = n - 1, j = 0; i >= idx; i--, j++) {
            sub[j] = arr[i];
        }
        for (int i = 0; i < idx; i++) System.out.print(arr[i] + " ");
        for (int i = 0; i < sub.length; i++) System.out.print(sub[i] + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr, n);
    }
}
