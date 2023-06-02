import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문자열화폐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int len = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		if(x < len) {
			flag =false;
		}
		if (x / 26 > len) {
			flag = false;
		}
		if (x / 26 == len && x % 26 != 0) {
			flag = false;
		}
		if (flag) {
			char map[] = new char[len];
			x-=len;
			for (int i = len - 1; i >= 0; i--) {
				map[i] = 'A';
				if (x >= 25) {
					x -= 25;
					map[i] +=25;
				} else if(x>0 && x<25){
					map[i]+=x; 
					x=0;
				}
				sb.append(map[i]);
			}
			sb.reverse();
			System.out.println(sb);
		}else {
			System.out.println('!');
		}
	}
}