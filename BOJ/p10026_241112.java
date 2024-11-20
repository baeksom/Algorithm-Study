import java.util.*;
import java.io.*;
public class p10026_241112 {
	
	static int n;
	static char[][] painting, p;
	static boolean[][] ch;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		painting = new char[n][n];
		p = new char[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				painting[i][j] = str.charAt(j);
				p[i][j] = str.charAt(j);
			}
		}
		ch = new boolean[n][n];
		int normal = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(p[i][j] == 'R' || p[i][j] == 'G' || p[i][j] == 'B') {
					normal++;
					normal(i, j, p[i][j]);
				}
			}
		}
		
		sb.append(normal).append(" ");
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				p[i][j] = painting[i][j];
			}
		}
		
		int special = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(p[i][j] == 'B') {
					special++;
					normal(i, j, 'B');
				}
				else if(p[i][j] == 'R' || p[i][j] =='G') {
					special++;
					special(i, j);
				}
			}
		}
		sb.append(special);
		System.out.println(sb.toString());
	}
	public static void normal(int x, int y, char color) {
		p[x][y] = 'N'; // 방문했음
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && p[nx][ny] == color) {
				normal(nx, ny, color);
			}
		}
	}
	
	public static void special(int x, int y) {
		p[x][y] = 'N';
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && (p[nx][ny] == 'R' || p[nx][ny] == 'G')) {
				special(nx, ny);
			}
		}
	}
}