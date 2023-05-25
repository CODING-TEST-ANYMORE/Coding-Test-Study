package Programmers;
// 프로그래머스 - 가장 큰 수
import java.util.*;
public class Main {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str, Comparator.reverseOrder());
        for (String s : str) {
            System.out.println(s);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9, 301};
        solution(numbers);
    }
}
