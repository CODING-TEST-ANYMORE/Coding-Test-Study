package Programmers;
// 프로그래머스 - 숫자 카드 나누기
import java.util.*;
public class Main {
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        // 각 배열의 최대공약수 구하기
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 0; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 최대공약수로 상대 배열 나눠지는지 확인
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                gcdA = -1;
                break;
            }
        }

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                gcdB = -1;
                break;
            }
        }

        // 가능한 답이 없으면 0 반환
        if (gcdA == -1 && gcdB == -1) return 0;
        // 둘 중 큰 값 정답으로 반환
        else return Math.max(gcdA, gcdB);
    }

    public static void main(String[] args) {
        int[] arrayA = {14,35,119};
        int[] arrayB = {18,30,102};

        System.out.println(solution(arrayA, arrayB));
    }



}
