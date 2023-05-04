package Programmers;
// 프로그래머스 - 더 맵게 (힙)
/**
1. 원소들을 우선순위 큐에 넣는다
2. 스코빌 지수가 가장 낮은 음식이 k보다 크면 반복문을 멈춘다.
2-1. 이때 큐에 음식이 1개 이하면 -1 반환
2-2. 음식 두개를 꺼내서 작업하고 다시 넣어줌
 */
import java.util.*;
public class Solution_025 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            // 1. 우선순위 큐에 넣음
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                pq.add(scoville[i]);
            }

            // 2.
            while(pq.peek() < K) {
                if (pq.size() < 2) return -1;
                int first = pq.poll();
                int second = pq.poll();
                pq.add(first + second * 2);
                answer++;
            }
            return answer;
        }
    }
}
