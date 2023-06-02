package Programmers;
// 프로그래머스 - 소수 찾기
// 소수 문제 !! -> 루트 씌운 거까지만 확인하면 됨!!
import java.util.*;
public class Main {
    HashSet<Integer> numberSet = new HashSet<>();
    public void recursive(String comb, String others) { // 재귀함수
        // comb -> 여태까지 조합된 숫자
        // others -> 여태까지 쓰지 않은 숫자

        // 1. 현재 조합을 set에 추가한다.
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
        // 2. 남은 숫자 중 한 개를 더 해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    }

    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if (num == 0 || num == 1) return false;
        // 2. 에라토스테네스의 체의 limit을 계산한다.
        int limit = (int)Math.sqrt(num);
        // 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int solution(String numbers) {
        int count = 0;
        // 1. 모든 조합의 숫자를 만든다.
        recursive("",numbers); // ""-> 여태까지 조합된 숫자 없음, numbers -> 여태까지 쓰지 않은 숫자

        // 2. 소수의 개수만 센다.
        // numberSet의 요소 하나하나 다 꺼내서 뭔가를 하고 싶을 때 iterator 사용 (hasNext, next, remove 등등의 함수 존재)
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) { // 다음 요소가 있냐
            int number = it.next();
            if (isPrime(number))
               count++;
        }
        // 3. 소수의 개수를 반환한다.
        return count;
    }
}
