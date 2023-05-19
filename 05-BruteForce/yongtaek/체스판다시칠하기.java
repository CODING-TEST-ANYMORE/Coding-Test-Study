import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class 체스판다시칠하기 {
    static boolean board[][];
    static int min = 64;

    public static void count(int a, int b) {
        boolean firstEdge = board[a][b];
        boolean boardColor = firstEdge;
        int count = 0;
        
        for(int i = a; i < a+8; i++) {
            for(int j = b; j < b+8; j++) {
                if(board[i][j] != boardColor){
                    count++;
                }
                if(j != b+7) boardColor = (!boardColor);
            }
        }

        count = Math.min(count, 64 - count);

        if(count < min) min = count;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String color = br.readLine();
            for(int j = 0; j < m; j++) {
                if(color.charAt(j) == 'W'){
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        for(int i = 0; i < n-7; i++) {
            for(int j = 0; j < m-7; j++) {
                count(i,j);
            }
        }

        System.out.println(min);
    }
}
