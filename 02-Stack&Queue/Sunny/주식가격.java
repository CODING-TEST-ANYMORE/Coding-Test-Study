package Programmers;
// 프로그래머스 - 주식 가격
import java.util.*;
public class Solution_021 {
//    스택 문제길래 스택으로 풀다가 시간 초과 계속 남
//    그리고 처음에 문제를 잘못 이해함.. 한번 떨어지면 stop해야 하는데 그 뒤에 오르면 또 세주는 걸로 생각했음
    
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    answer[i]++;
                    if (prices[i] > prices[j]) break;
                }
            }

            return answer;
        }
    }
}
