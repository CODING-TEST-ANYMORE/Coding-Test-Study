package Programmers;
// 프로그래머스 - 소수 찾기 (Lv2)
import java.util.*;
public class Solution_026 {
    static Set<Integer> set = new HashSet<>(); // 소수 담음

    public static boolean isPrime(int num) { // 소수인지 확인
        if (num < 2) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            String s = "";
            for (int i = 0; i < r; i++) {
                s += output[i];
            }
            set.add(Integer.parseInt(s));
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = arr[i];
                    perm(arr, output, visited, depth + 1, n, r);
                    visited[i] = false;
                }
            }
        }
    }

    public static int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(numbers.charAt(i)));
        }
        for (int i = 1; i <= numbers.length(); i++) {
            int[] output = new int[i];
            boolean[] visited = new boolean[numbers.length()];
            perm(arr, output, visited, 0, numbers.length(), i);
        }
        int answer = 0;
        for (int num: set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
