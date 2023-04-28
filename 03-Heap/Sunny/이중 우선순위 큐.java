package Baekjoon;
// 백준 7662번 - 이중 우선순위 큐
/**
[실패] 시간초과..
1. 삽입일 때는 그냥 우선순위 큐에 넣음
2. 최댓값 삭제일 때는 
2-1. 임시 우선순위 큐 만들어서 
2-2. 마지막 원소 직전까지만 넣음 --> 그거 반환
3. 최솟값 삭제일 때는 그냥 poll
 */
import java.util.*;
import java.io.*;
public class Solution_7662 {
    static int T;

    public static PriorityQueue<Integer> d1(PriorityQueue<Integer> pq) { // 최댓값 삭제
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        int cnt = pq.size() - 1;
        for (int l = 0; l < cnt; l++) {
            temp.add(pq.poll());
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String[] answer = new String[T];

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순
            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                char func = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);
                if (func == 'I') { // 삽입
                    pq.add(num);
                } else if (func == 'D' && num == 1) { // 최댓값 삭제
                    if (pq.isEmpty()) continue;
                    pq = d1(pq);
                } else if (func == 'D' && num == -1) { // 최솟값 삭제
                    if (pq.isEmpty()) continue;
                    pq.poll();
                }
            }
            // 정답 처리
            if (pq.isEmpty()) {
                answer[i] = "EMPTY";
            } else {
                Object[] arr = pq.toArray();
                int min = (int)arr[0];
                int max = (int)arr[pq.size() - 1];
                String str = max + " " + min;
                answer[i] = str;
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}
