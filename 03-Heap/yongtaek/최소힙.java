import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < n ; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pQueue.isEmpty()){
                    sb.append(0+"\n");
                    continue;
                }
                sb.append(pQueue.poll()+"\n");
            } else {
                pQueue.offer(num);
            }
        }

        System.out.println(sb);
    }
}
