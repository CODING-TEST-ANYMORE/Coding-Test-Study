package Baekjoon;
// 백준 14888번 - 연산자 끼워넣기
import java.util.*;
public class Solution_14888 {
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int N;
    public static int[] arr;
    public static void perm(ArrayList<String> operators, String[] output, boolean[] visited, int depth) {
        if (depth == N - 1) {
            calculate(output);
            return;
        } else {
            for (int i = 0; i < N - 1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = operators.get(i);
                    perm(operators, output, visited, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void calculate (String[] output) {
        int tmp = arr[0];
        if (output[0].equals("+")) tmp += arr[1];
        else if (output[0].equals("-")) tmp -= arr[1];
        else if (output[0].equals("*")) tmp *= arr[1];
        else if (output[0].equals("/")) tmp /= arr[1];

        for (int i = 2, j = 1; i < N && j < N -1; i++, j++ ) { // i for arr, j for output(operators)
            if (output[j].equals("+")) tmp += arr[i];
            else if (output[j].equals("-")) tmp -= arr[i];
            else if (output[j].equals("*")) tmp *= arr[i];
            else if (output[j].equals("/")) tmp /= arr[i];
        }
        min = Math.min (tmp, min);
        max = Math.max (tmp, max);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<String> operators = new ArrayList<>();
        for (int i = 0; i < 4; i++) { // +, -, *, /
            int x = sc.nextInt();
            if (x == 0) continue;;
            for (int j = 0; j < x; j++) {
                if (i == 0) operators.add("+");
                else if (i == 1) operators.add("-");
                else if (i == 2) operators.add("*");
                else if (i == 3) operators.add("/");
            }
        }
        //
        String[] output = new String[N - 1];
        boolean[] visited = new boolean[N - 1];
        perm(operators, output, visited, 0);
        System.out.println(max);
        System.out.println(min);
    }
}
