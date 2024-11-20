import java.io.*;
public class p2579_241112 {
	static Integer[] dp;
	static int[] stairs;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new Integer[n+1];
		stairs = new int[n+1];
		for(int i=1; i<=n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stairs[0]; // 0번째 계단
		dp[1] = stairs[1]; // 1번째 계단
		if(n >= 2) {
			dp[2] = stairs[1] + stairs[2]; // 2번째 계단은 무조건 두개다 오른 게 최대값
		}
		System.out.println(recur(n));
	}
	static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(recur(n-2), recur(n-3) + stairs[n-1]) + stairs[n];
		}
		return dp[n];
	}
}