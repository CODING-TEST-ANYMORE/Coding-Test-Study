import java.util.*;

class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        
        for (int i = 0; i < scoville.length; i++) {
            pQueue.add(scoville[i]);
        }
        
        while(pQueue.peek() < K){
            
            int min1 = pQueue.poll();
            int min2 = pQueue.poll();
            
            pQueue.add(min1 + min2 * 2);
            answer++;
            
            if(pQueue.peek() >= K) break;
            if(pQueue.size() == 1 && pQueue.peek() < K) {
                answer = -1; 
                break;
            }
        }
        
        return answer;
    }
}