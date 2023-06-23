package Programmers;
// 프로그래머스 - 위장
import java.util.*;
public class Main {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            int count = map.get(key) + 1;
            answer *= count;
        }
        return answer - 1;
    }
}
