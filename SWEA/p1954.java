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
            int[][] arr = new int[n][n];
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            int d = 1;
            int x = 0, y = 0;
            arr[x][y] = 1;
            int cnt = 2;
            while (cnt == n*n+1) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    arr[nx][ny] = cnt;
                    System.out.println("cnt : " + cnt);
                    cnt++;
                } else {
                    d = (d+1) % 4;
                }
            }
            System.out.println("#" + test_case);
            for(int[] i : arr) {
                for(int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
		}
	}
}