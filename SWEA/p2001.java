import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n][n];
            int max = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<n-m+1; i++) {
                for(int j=0; j<n-m+1; j++) {
                    int sum = 0;
                    for(int x = 0; x<m; x++) {
                        for(int y=0; y<m; y++) {
                            sum += board[i+x][j+y];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#"+test_case+" " + max);
		}
    }
}