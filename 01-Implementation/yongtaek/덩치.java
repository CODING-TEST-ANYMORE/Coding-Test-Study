import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class 덩치 {
    static int res[];
    static int arr[][];
    static int n;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        res = new int[n];

        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < 2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if((arr[j][0] > arr[i][0]) && (arr[j][1] > arr[i][1])) {
                    count++;
                }
            }
            res[i] = count + 1;
        }

        for(int i = 0; i < res.length; i++){
            sb.append(res[i] + " ");
        }

        System.out.println(sb);
    }
}
