
// 프로그래머스 - 2개 이하로 다른 비트
import java.util.*;
public class Solution {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        // 1. 2진수로 변환
        String[] nums = {};
        for (int i = 0; i < numbers.length; i++) {
            String str = Long.toBinaryString(numbers[i]); // int -> 2진수 String으로
            int index = str.lastIndexOf('0'); // right에 0이 존재하는지 끝에서 부터 찾음
            // 만약 0이 존재한다면 그 0을 1로 바꿔줌
            if (index != -1) {
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(index, '1');
                str = sb.toString(); // 0을 1로 바꿔줬음
                int index2 = str.indexOf('1', index + 1);
                if (index2 != -1) {
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.setCharAt(index2, '0');
                    str = sb2.toString();
                }
                answer[i] = Long.parseLong(str, 2);
            } else { // 만약 오른쪽에 0이 존재하지 않는다면 왼쪽에 1을 추가해줘야 함
                StringBuffer sb = new StringBuffer(str);
                sb.insert(0, '1');
                sb.setCharAt(1, '0');
                str = sb.toString();
                answer[i] = Long.parseLong(str, 2);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        long [] a = {2, 7};
        solution(a);
    }
}
