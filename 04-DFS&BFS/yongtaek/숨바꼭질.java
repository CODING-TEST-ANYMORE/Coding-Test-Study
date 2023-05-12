import java.util.*;
import java.io.*;

public class 숨바꼭질 {
    static int N;
    static int K;
    static int count = 0;
    static int[] second = new int[100001];

    public static void BFS(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int position = queue.poll();

            if (position == K) {
                count = second[position];
                break;
            }

            if (position > 0 && second[position - 1] == 0) {
                queue.offer(position - 1);
                second[position - 1] = second[position] + 1; 
            }

            if (position < 100000 && second[position + 1] == 0) {
                queue.offer(position + 1);
                second[position + 1] = second[position] + 1; 
            }

            if (position != 0 && position <= 50000 && second[position * 2] == 0) {
                queue.offer(position * 2);
                second[position * 2] = second[position] + 1; 
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);

        System.out.println(count);
    }
}
