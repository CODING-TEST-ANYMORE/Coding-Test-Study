package Programmers;
// 프로그래머스 - 괄호 변환
import java.util.*;
public class Solution_023 {
    public boolean isRight(String s) { // 올바른 괄호 문자열인지 체크!
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if(st.isEmpty()) { //
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

    public String solution(String p) {
        if (p.length() == 0) return ""; // 빈문자열인 경우
        String u = "";
        String v = "";
        int left = 0, right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            u += p.charAt(i);
            if (i != 0 && left == right) {
                for (int j = i + 1; j < p.length(); j++) {
                    v += p.charAt(j);
                }
                break;
            }
        }
        if (isRight(u)) {
            return u + solution(v);
        } else {
            String tmp = "(" + solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            for (int k = 0; k < u.length(); k++) {
                if (u.charAt(k) == '(')
                    u = u.substring(0, k) + ')' + u.substring(k + 1);
                else
                    u = u.substring(0, k) + '(' + u.substring(k + 1);
            }
            tmp += u;
            return tmp;
        }
    }
}