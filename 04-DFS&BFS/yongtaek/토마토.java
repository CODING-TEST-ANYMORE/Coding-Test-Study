import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {
    static int[][][] graph;
    static int h;
    static int n;
    static int m;
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};

    static LinkedList<Point> queue = new LinkedList<>();
    public static class Point {
        private int z,x,y;

        Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            
            int pollz = point.z;
            int pollx = point.x;
            int polly = point.y;

            for(int i = 0; i < 6; i++) {
                int newz = pollz + dz[i];
                int newx = pollx + dx[i];
                int newy = polly + dy[i];

                if(newz <= -1 || newx <= -1 || newy <= -1 || newz >= h || newx >= n || newy >= m ) {
                    continue;
                }

                if(graph[newz][newx][newy] == 0) {
                    queue.offer(new Point(newz, newx, newy));
                    graph[newz][newx][newy] = graph[pollz][pollx][polly] + 1;
                }
            }
        }
    }
    public static int getMax(int [][][] graph) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < h; i++) {
            for(int j = 0 ; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(graph[i][j][k] > max) {
                        max = graph[i][j][k];
                    }
                }
            }
        }
        return max - 1;
    }

    public static int countZeros(int [][][] graph) {
        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0 ; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(graph[i][j][k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h][n][m];

        for(int i = 0; i < h; i++) {
            for(int j = 0 ; j < n; j++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int k = 0; k < m; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());

                    if(graph[i][j][k] == 1) {
                        queue.offer(new Point(i, j, k));
                    }
                }
            }
        }

        if(countZeros(graph) == 0) {
            System.out.println(0);
        } else {
            bfs();

            if(countZeros(graph) == 0) {
                System.out.println(getMax(graph));
            } else {
                System.out.println(-1);
            }
        }
    }
}
