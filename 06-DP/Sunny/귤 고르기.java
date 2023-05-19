package Programmers;
// 프로그래머스 - 귤 고르기
import java.util.*;
public class Main {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        // 1. Hash map에 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine)
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        // 2. Hash map에서 value를 기준으로 내림차순 정렬
        List<Integer> listKeySet = new ArrayList<>(map.keySet());
        listKeySet.sort((o1, o2) -> map.get(o2)-map.get(o1));
//        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));

        // 3. k개 가져오기
        int sum = 0;
        for (Integer key : listKeySet) {
            int num = map.get(key);
            sum += num;
            answer++;
            if (sum >= k) break;
        }

        return answer;


    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
        int ans = solution(6, arr);
        System.out.println(ans);

    }
}
