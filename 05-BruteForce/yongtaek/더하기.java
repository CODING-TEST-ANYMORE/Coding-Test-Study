import java.io.*;

//brute force지만 dp를 썼습니다
//효율이 더 좋거덩요...
public class 더하기 {
    public static void main(String args[]) throws IOException {
        int dp[] = new int[11];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]+"\n");
        }

        System.out.println(sb);
    }
}
