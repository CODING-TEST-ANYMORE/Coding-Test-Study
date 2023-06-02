package Baekjoon;
// 백준 1789번 - 수들의 합
import java.util.*;
public class Solution_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long S = sc.nextLong();
        Long num = (long) 1;
        Long sum = (long) 0;

        while (true) {
            sum += num;
            num++;
            if (sum > S) {
                System.out.println(num - 2);
                break;
            } else if (sum.equals(S)) {
                System.out.println(num - 1);
                break;
            }
        }
    }
}
