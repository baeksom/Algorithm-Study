import java.util.*;
import java.io.*;
public class p10026_241113 {
	static char[][] painting;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		painting = new char[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				painting[i][j] = str.charAt(j);
			}
		}
		
		int normalCnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					normalCnt++;
					dfs(i, j);
				}
			}
		}
		
		sb.append(normalCnt).append(" ");
		
		int abnormalCnt = 0;
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(painting[i][j] == 'R') painting[i][j] = 'G';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					abnormalCnt++;
					dfs(i, j);
				}
			}
		}
		sb.append(abnormalCnt);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		char color = painting[x][y];
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && painting[nx][ny] == color) {
				dfs(nx, ny);
			}
		}
	}
}