package Programmers;
// 프로그래머스 - 베스트앨범
import java.util.*;
public class Solution_019 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 1. HashMap 만들기
        HashMap<String, Integer> count = new HashMap<>(); // genre별 총 재생 횟수 담음
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>(); // 장르별로 음악 리스트를 담음

        for (int i = 0; i < genres.length; i++) {
            if (count.containsKey(genres[i])) {
                // 담은 적이 있는 장르다!
                count.put(genres[i], count.get(genres[i]) + plays[i]); // genre별 총 재생 횟수 업데이트
                map.get(genres[i]).put(i, plays[i]); // (고유번호, 재싱횟수) 담음

            } else {
                // 처음 담는 장르다!
                count.put(genres[i], plays[i]); // genre별 총 횟수 담음
                HashMap<Integer, Integer> tmp = new HashMap<>(); // 장르별 음악 리스트
                tmp.put(i, plays[i]);
                map.put(genres[i], tmp);
            }
        }

        // 2. 정렬
        // 2-1. 총 재생횟수를 기준으로 정렬
        List<String> keySet = new ArrayList(count.keySet());
        Collections.sort(keySet, (o1, o2) -> count.get(o2) - (count.get(o1)));
        System.out.println(keySet);
        // 2-2. 각 장르 내에서 정렬
        for (String key: keySet) {
            // 일단 장르 내에서 음악 정렬
            HashMap<Integer, Integer> temp = map.get(key);
            List<Integer> musicKey = new ArrayList(temp.keySet());
            Collections.sort(musicKey, (o1, o2) -> temp.get(o2) - (temp.get(o1)));
            System.out.println(musicKey);
            // 첫번째 음악 정답 리스트에 담음
            answer.add(musicKey.get(0));
            // 음악이 2개 이상이면 두번째 음악 정답 리스트에 담음
            if (musicKey.size() > 1) {
                answer.add(musicKey.get(1));
            }
        }
        // ArrayList -> int[]
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution_019 sol = new Solution_019();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(sol.solution(genres, plays));
    }

}
