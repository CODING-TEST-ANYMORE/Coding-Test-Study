package Baekjoon;
// 백준 5430번 - AC
/**
[실패] IDE에서 테스트케이스는 맞췄으나 채점했을 때 시간초과 남..
1. 함수 입력받아서 charArray로 변환
2. 원소 입력받기
2-1. 원소배열을 string으로 입력 받음
2-2. , 기준으로 split
2-3. 열심히 [ 들을 제거해줌..
3. calculate 함수에서 reverse 하거나 delete!
 */
import java.util.*;
public class Solution_5430 {
    static int T;
    static HashMap<Integer, char[]> functions = new HashMap<>(); // 합수들
    static HashMap<Integer, Queue<Integer>> intArr = new HashMap<>(); // 테스트 숫자 배열들
    static HashMap<Integer, Queue<Integer>> answers = new HashMap<>(); // 정답

    public static Queue<Integer> reverseQueue(Queue<Integer> queue) { // 문자열 뒤집읍
        Stack<Integer> st = new Stack<>();
        while (!queue.isEmpty()) {
            st.push(queue.poll());
        }
        while (!st.empty()) {
            queue.add(st.pop());
        }
        return queue;
    }

    public static void calculate(char[] function, Queue<Integer> queue, int num) { //여기서 num은 몇번째 테스트 케이스인지
        // function --> R,D,D
        // queue -->1,2,3,4
        for (int i = 0; i < function.length; i++) {
            if (function[i] == 'R') { // 뒤집기
                queue = reverseQueue(queue);
            } else { // 'D'일 때
                if (queue.isEmpty()) { // 에러 상황!
                    answers.put(num, null);
                    return;
                } else {
                    queue.poll();
                }
            }
            if (i == function.length - 1) { // 마지막 형태 정답으로 저장
                answers.put(num, queue);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            // 합수 -> 원소 개수 -> 배열(String) 순으로 입력 받음!
            // 1. 함수 입력 받기
            String func = sc.next();
            char[] funcs = func.toCharArray();
            functions.put(i, funcs);
            // 2. 원소 입력 받기
            int n = sc.nextInt(); // 원소의 개수
            String str = sc.next(); // 배열을 string으로 받음
            String[] strArr = str.split(","); // ,를 기준으로 자름

            Queue<Integer> que = new LinkedList<>(); // 원소들을 큐에 넣을 거임
            if (n == 1 || n == 0) {
                if (n == 1) {
                    que.add(Integer.parseInt(strArr[0].substring(1, strArr[0].length() - 1)));
                }
            } else {
                for (int j = 0; j < n; j++) { // 큐에 넣기!
                    if (j == 0) { // 첫번째 원소 -> [ 제거해주기!
                        que.add(Integer.parseInt(strArr[j].substring(1))); // beginIndex
                    } else if (j == n - 1) { // 마지막 원소 -> ] 제거해주기!
                        que.add(Integer.parseInt(strArr[j].substring(0, strArr[j].length() - 1)));
                    } else {
                        que.add(Integer.parseInt(strArr[j]));
                    }
                }
            }
            if (n == 0) {
                intArr.put(i, null);
            } else {
                intArr.put(i, que);
            }

        }
        // 3. 계산 시작
        for (int i = 0; i < T; i++) {
            if (intArr.get(i) == null) {
                answers.put(i, null);
            } else {
                calculate(functions.get(i), intArr.get(i), i);
            }

        }
        // 4. 출력
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) == null) {
                System.out.println("error");
            } else {
                System.out.println(answers.get(i));
            }
        }

    }
}