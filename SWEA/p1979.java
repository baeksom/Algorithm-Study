import java.util.*;
class p1979
{
	static int[][] board;
	static int n, k, cnt;
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			board = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(board[i][j] == 1) {
						if(checkRow(i,j)) cnt++;
						if(checkCol(i,j)) cnt++;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	public static boolean checkRow(int i, int j) {
		if(j-1 >=0 && board[i][j-1] == 1) return false;
		for(int s=1; s<k; s++) {
			if(j+s >= n || board[i][j+s] == 0) return false; 
		}
		if(j+k < n && board[i][j+k] == 1) return false;
		return true;
	}
	public static boolean checkCol(int i, int j) {
		if(i-1 >= 0 && board[i-1][j] == 1) return false;
		for(int s=1; s<k; s++) {
			if(i+s >= n || board[i+s][j] == 0) return false;
		}
		if(i+k < n && board[i+k][j] == 1) return false;
		return true;
	}
}