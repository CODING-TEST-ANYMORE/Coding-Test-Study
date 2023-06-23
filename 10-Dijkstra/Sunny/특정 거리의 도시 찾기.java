package Baekjoon;
// 백준 18352번 -  특정거리의 도시 찾기
import java.io.*;
import java.util.*;

public class Solution_18352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] d = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
        }

        d[X] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < graph.get(curr).size(); i++) {
                int next = graph.get(curr).get(i);
                if(d[next] == -1) {
                    d[next] = d[curr] + 1;
                    q.offer(next);
                }
            }
        }

        boolean chk = false;
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println(i);
                chk = true;
            }
        }
        if(!chk) System.out.println(-1);
    }
}
