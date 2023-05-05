import java.util.*;
import java.io.*;

public class DFS와BFS {
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] graph;
    static Boolean[] visited;
    
    public static void initVisited() {
        for(int i = 1; i < N +1; i++) {
            visited[i] = false;
        }
        System.out.print("\n");
    }

    public static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int i : graph[start]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int pollStart = queue.poll();

            System.out.print(pollStart + " ");

            for(int i : graph[pollStart]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i); 
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new Boolean[N + 1];

        for(int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        DFS(V);

        initVisited();

        BFS(V);
    }
}