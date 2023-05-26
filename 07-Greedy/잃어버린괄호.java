import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        
        int result = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            int sum = 0;
            
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
            while(st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }

            if(result == Integer.MAX_VALUE) {
                result = sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
