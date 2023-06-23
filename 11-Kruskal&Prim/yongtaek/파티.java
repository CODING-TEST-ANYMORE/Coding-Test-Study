import java.io.*;
import java.util.*;

public class 파티 {
    static ArrayList<Pair>[] graph;
    static long[] distance;
    static ArrayList<Long> result;

    public static class Pair implements Comparable<Pair>{
        int end;
        int time;

        Pair(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.time == p.time) {
                return this.end - p.end;
            }

            return this.time - p.time;
        }
    }

    public static long dijkstra(int start, int end) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pQueue = new PriorityQueue<>();

        pQueue.offer(new Pair(start, 0));
        distance[start] = 0;

        while(!pQueue.isEmpty()) {
            Pair poll = pQueue.poll();
            int pollEnd = poll.end;
            int pollTime = poll.time;

            if(distance[pollEnd] < pollTime) {
                continue;
            }

            for(Pair p: graph[pollEnd]) {
                int cost = p.time + pollTime;
                if(cost < distance[p.end]) {
                    distance[p.end] = cost;
                    pQueue.offer(new Pair(p.end, cost));
                }
            }
        }
        return distance[end];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        distance = new long[n+1];
        result = new ArrayList<>();

        for(int i = 1; i < n+1; i++) {
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Pair(end, time));
        }

        for(int i = 1; i < n+1; i++) {
            result.add(dijkstra(i,x) + dijkstra(x,i));
        }

        System.out.println(Collections.max(result));
    }
}