import java.util.*;
class Solution
{
	static int n, answer;
	static int[] arr;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			arr = new int[n];
			answer = 0;
			
			dfs(0);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static void dfs(int L) {
		if(L == n) {
			answer++;
			return;
		}
		for(int i=0; i<n; i++) {
			arr[L] = i;
			
			if(isPossible(L)) {
				dfs(L+1);
			}
		}
	}
	
	public static boolean isPossible(int depth) {
		for(int i=0; i<depth; i++) {
			if(arr[i] == arr[depth] || depth-i == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}