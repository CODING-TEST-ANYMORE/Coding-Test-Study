package Programmers;
// 프로그래머스 - 올바른 괄호
import java.util.*;
public class Solution_020 {

    class Solution {
        boolean solution(String s) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') { // '('가 들어오면 스택에 넣어줌
                    st.push(s.charAt(i));
                } else { // ')'가 들어왔다면 '('를 내보내줘야 함
                    if (st.empty()) { // 스택에 '('가 없는 상황
                        return false;
                    }
                    st.pop(); // ')' 짝꿍인 '('을 내보내줌
                }
            }
            return st.empty(); // '('가 남아있을 경우에는 false임
        }
    }
}
