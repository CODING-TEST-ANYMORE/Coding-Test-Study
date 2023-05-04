package Baekjoon;
// 백준 1697번 - 숨바꼭질
/*
* 1. 동생이 수빈이보다 뒤에 있는 경우는 -1 걷기 밖에 안되므로 바로 정답 return
* 2. BFS를 이용해서 구함
* 2-1. 큐에서 앞의 원소를 꺼낸 후 3가지 (얖으로 걷기, 순간이동, 뒤로 걷기)를 실행한 값에 대해 조건 체크한다.
* 2-2. 동생과 만난 경우 return
* 2-3. next가 범위 안에 있는 지 체크 && 방문한 적 없는지 체크 -> 조건 충족시 큐에 넣고 time도 업데이트해줌
* */
import java.util.*;
public class Solution_1697 {
    public static int solution(int N, int K) {
        if (N >= K) return N - K;
        int[] time = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                switch (i) {
                    case 0:
                        next = now + 1;
                        break;
                    case 1:
                        next = now * 2;
                        break;
                    default:
                        next = now - 1;
                }
                if (next == K) return time[now] + 1;
                if (next >= 0 && next <= 100000 && time[next] == 0) {
                    time[next] = time[now] + 1;
                    q.offer(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solution(N, K));
    }
}
