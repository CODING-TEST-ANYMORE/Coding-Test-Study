// 백준 18311번 - 왕복
import java.util.*;
public class Solution_18311 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long k = sc.nextLong();
        int[] course = new int[n];
        int half = 0;
        for(int i = 0; i < n; i++) {
            course[i] = sc.nextInt();
            half += course[i];
        }
        int ans = 0;

        if (k == half) {
            ans = n;
        } else if (k == half * 2) {
            ans = 1;
        } else if (k < half) {
            for (int i = 0; i < n; i++) {
                k -= course[i];
                if (k < 0) {
                    ans = i + 1;
                    break;
                }
            }
        } else {
            k -= half;
            for (int i = n - 1; i >= 0; i--) {
                k -= course[i];
                if (k < 0) {
                    ans = i + 1;
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}
