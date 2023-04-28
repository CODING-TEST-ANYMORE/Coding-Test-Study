package Programmers;
// 프로그래머스 - 문자열 압축
import java.util.*;
public class Solution_024 {
    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;
            int ans = 0;
            String str = s;
            String prev = str.substring(0, i);
            str = str.substring(i);
            for (int j = 1; j < (s.length()/i); j++) {
                String curr = str.substring(0, i);
                if (curr.equals(prev)) {
                    cnt ++;
                } else {
                    if (cnt >= 2) {
                        ans += i + String.valueOf(cnt).length();
                    } else {
                        ans += i;
                    }
                    cnt = 1;
                }
                if (j == (s.length()/i - 1)){
                    if (cnt >= 2) {
                        ans += i + String.valueOf(cnt).length();
                    } else {
                        ans += i;
                    }
                }
                prev = curr;
                str = str.substring(i);
            }
            ans += s.length() % i;
            min = Math.min(min, ans);
        }

        return min;
    }

    public static void main(String[] args) {
//        Solution_024 sol = new Solution_024();
//        System.out.println(sol.solution("aaaa"));
        int length = String.valueOf(3).length();
        System.out.println(length);
    }
}
