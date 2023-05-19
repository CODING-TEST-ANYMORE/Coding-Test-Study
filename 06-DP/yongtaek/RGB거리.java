import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
    static int [][] dp;
    static int [][] paint;

    public static void paint(int n) {
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    dp[i][j] = paint[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                } else if (j == 1) {
                    dp[i][j] = paint[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                } else {
                    dp[i][j] = paint[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        paint = new int [n][3];
        dp = new int [n][3];

        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = paint[0][0];
        dp[0][1] = paint[0][1];
        dp[0][2] = paint[0][2];

        paint(n);

        int min = Math.min(dp[n-1][0], dp[n-1][1]);
        min = Math.min(min, dp[n-1][2]);

        System.out.println(min);
    }  
}
