package Programmers;
// 프로그래머스 - 기능개발
import java.util.*;
public class Main {
    public static Stack<Integer> solution(int[] progresses, int[] speeds) throws EmptyStackException {
        Stack<Integer> answer = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<>();

        // 1. stack에 걸리는 일수 계산해서 넣기
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(days);
        }
        System.out.println(queue);
        // 2.
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int num = 1;
            while (queue.peek() != null && cur >= queue.peek()) {
                queue.poll();
                num++;
            }
            answer.add(num);
        }

        return answer;
    }

}
