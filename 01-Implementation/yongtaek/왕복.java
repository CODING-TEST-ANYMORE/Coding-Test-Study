import java.util.*;
import java.io.*;

public class 왕복 {
    static int[] distance;
    static int[] firstLap;
    static int[] secondLap;
    static int N;
    static Long K;

    public static int findLap(int distance, int[] lap, Boolean isFirstLap) {
        int currentLap = 0;

        for(int i = 1; i < N+1; i++) {
            if(distance < lap[i]) {
                if(isFirstLap) currentLap = i;
                else currentLap = N-i+1;
                break;
            }
        }

        return currentLap;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        distance = new int[N+1];
        firstLap = new int[N+1];
        secondLap = new int[N+1];

        firstLap[0] = 0;
        secondLap[0] = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N+1; i++) {
            firstLap[i] = firstLap[i-1] + distance[i];
            secondLap[i] = secondLap[i-1] + distance[N-i+1];
        }

        int LapDistance = firstLap[N];

        int solution = 0;

        if(K <= LapDistance) {
            solution = findLap(K.intValue(), firstLap, true);
        } else {
            int secondLapDistance = K.intValue() - LapDistance;
            solution = findLap(secondLapDistance, secondLap, false);
        }

        System.out.println(solution);
    }
}