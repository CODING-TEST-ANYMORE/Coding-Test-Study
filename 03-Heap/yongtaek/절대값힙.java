import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절대값힙 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer p1, Integer p2) {
                if(Math.abs(p1) == Math.abs(p2)) {
                    if(p1 > p2) { 
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return Math.abs(p1) - Math.abs(p2);
            }
        });

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
