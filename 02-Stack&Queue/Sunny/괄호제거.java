package Baekjoon;
// 백준 2800번 - 괄호 제거
import java.util.*;
/*
1. 입력받은 문자열에서 괄호쌍 찾기 --> EX, (()) -> [(0,3), (1,2)]
2. 괄호 list의 index로 부분집합 만들기
3. 위에서 만들어진 부분집합을 토대로 string 생성 
*/

public class Solution_2800 {
    static char[] arr; // 입력 받은 문자열
    static List<Bracket> brackets = new ArrayList<>(); // 괄호 쌍 담음 (index, index), ...
    static Set<String> answers = new HashSet<>(); // 정답 담음 --> set을 통한 중복 제거!

    static class Bracket{
        int x;
        int y;
        Bracket(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void makeStr(boolean[] isSelected) {
        char[] copy = arr.clone(); 
        int cnt = 0;
        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i] == true) {
                int idxX = brackets.get(i).x;
                int idxY = brackets.get(i).y;
                copy[idxX] = ' '; // 괄호 대신 공백으로 
                copy[idxY] = ' ';
                cnt++;
            }
        }
        if (cnt == 0) return; // 처음 입력받은 문자열과 똑같을 때는 출력 X
        String ans = new String(copy);
        answers.add(ans.replaceAll(" ", "")); // 공백제거해서
    }

    public static void makeSubset(int N, int count, boolean[] isSelected) { // 부분집합 만들기
        if (count == N) {
            makeStr(isSelected); // 만들어진 부분집합을 토대로 sring 생성
            return;
        }
        isSelected[count] = true;
        makeSubset(N, count + 1, isSelected);
        isSelected[count] = false;
        makeSubset(N, count + 1, isSelected);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        arr = str.toCharArray();

        // 괄호 쌍 찾기
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                st.push(i);
            } else if (arr[i] == ')') {
                int left = st.pop();
                brackets.add(new Bracket(left, i));
            }
        }

        // 부분 집합 만들기
        boolean[] isSelected = new boolean[brackets.size()];
        makeSubset(brackets.size(), 0, isSelected);

        //
        ArrayList<String> al = new ArrayList<>(answers);
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i) + ' ');
        }

    }
}