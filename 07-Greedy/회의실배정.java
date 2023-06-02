import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] timeline = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");

            timeline[i][0] = Integer.parseInt(st.nextToken());
            timeline[i][1] = Integer.parseInt(st.nextToken());
        }     

        Arrays.sort(timeline, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if(a1[1] == a2[1]) {
                    return a1[0] - a2[0];
                } 
                return a1[1] - a2[1];
            }
        });

        int count = 0;
        int latestEnd = 0;
        
        for(int i = 0 ; i < n ; i++) {
            int start = timeline[i][0];
            int end = timeline[i][1];

            if(latestEnd <= start) {
                latestEnd = end;
                count++;
            }
        }

        System.out.println(count);
    }
}
