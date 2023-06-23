import java.io.*;
import java.util.*;

public class 운동 {
    static long[][] graph;
    static int v;
    static int e;

    public static class Pair {
        int b,c;

        Pair(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
    public static void floydWarshall() {
        for(int i = 1; i < v+1; i++) {
            for(int j = 1; j < v+1; j++) {
                for(int k = 1; k < v+1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new long[v+1][v+1];

        for(int i = 1; i < v+1; i++) {
            for(int j = 1; j < v+1; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0 ; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph[a][b] = c;
        }

        floydWarshall();

        long min = Integer.MAX_VALUE;

        for(int i = 1; i < v+1; i++) {
            if(graph[i][i] >= Integer.MAX_VALUE) continue;

            if(graph[i][i] < min) {
                min = graph[i][i];
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}