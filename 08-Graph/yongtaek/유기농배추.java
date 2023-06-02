import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int[][] graph;
    static int row;
    static int col;

    public static Boolean dfs(int x, int y) {
        if(x <= -1 || y <= -1 || x >= row || y >= col) {
            return false;
        }

        if(graph[x][y] == 1) {
            graph[x][y] = 0;

            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);

            return true;
        }

        return false;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph = new int[row][col];

            for(int j = 0; j < v; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;

            }

            int count = 0;
            for(int k = 0; k < row; k++) {
                for(int l = 0; l < col; l++) {
                    if(dfs(k,l) == true) {
                        count++;
                    }
                }
            }

            sb.append(count + "\n");
        }
        
        System.out.println(sb);
    } 
}
