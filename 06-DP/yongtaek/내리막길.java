import java.io.*;
import java.util.*;
 
public class 내리막길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c,answer;
	static int[][] arr;
	static int[][] enable;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
 
	static void init(){
		answer = 0;
		arr = new int[r][c];
		enable = new int[r][c];
		for(int i=0; i<r; ++i) Arrays.fill(enable[i],-1);
		enable[r-1][c-1] = 1;
		enable[0][0] = 0;
	}
 
	static boolean dfs(int x, int y){
		boolean flag = false;
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
			if(arr[nx][ny]>=arr[x][y] ) continue;
			if(enable[nx][ny]!=-1){
				enable[x][y] += enable[nx][ny];
				flag = true;
				continue;
			}
			enable[nx][ny] = 0;
			if(dfs(nx,ny)){
				enable[x][y] += enable[nx][ny];
				flag = true;
			}
		}
		return flag;
	}
 
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		init();
		for(int i=0; i<r; ++i)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dfs(0,0);
		System.out.println(enable[0][0]);
 
	}
}