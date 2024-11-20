import java.util.*;
class p5215
{
	static int n, L, answer;
	static int[][] arr;
	static int[] ch;
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			L = sc.nextInt();
			arr = new int[n][2]; // [0] - 점수 [1] - 칼로리
			ch = new int[n];
			for(int i=0; i<n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			answer = 0;
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " "+ answer);
		}
	}
	
	public static void dfs(int start, int scoreSum, int calSum) {
		if(calSum > L) return;
		else {
			answer = Math.max(answer, scoreSum);
			for(int i=start; i<n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					dfs(i, scoreSum + arr[i][0], calSum + arr[i][1]);
					ch[i] = 0;
				}
			}
		}
	}
}