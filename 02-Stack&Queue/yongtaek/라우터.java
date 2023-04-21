package Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 라우터 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        while(true) {
            int number = Integer.parseInt(br.readLine());

            if(number == -1) break;

            if(number == 0) queue.pop();

            if(queue.size() == n) continue;

            if(number != 0) queue.offer(number);
        }

        if(queue.isEmpty()) {
            System.out.println("empty");
        } else {
            for(int i: queue) {
                sb.append(i + " ");
            }
    
            System.out.println(sb);
        }
    }
}
