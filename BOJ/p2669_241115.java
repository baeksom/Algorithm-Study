import java.util.*;
import java.io.*;
public class p2669_241115 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[101][101];
		
		int cnt = 0;
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for(int x=lx; x<rx; x++) {
				for(int y=ly; y<ry; y++) {
					if(board[x][y] == 0) {
						cnt++;
						board[x][y] = 1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}