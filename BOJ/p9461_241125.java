import java.util.*;
import java.io.*;
public class p9461_241125 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[101];
		for(int test_case=0; test_case<T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			for(int i=6; i<=N; i++) {
				dp[i] = dp[i-5] + dp[i-1];
			}
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb.toString());
	}
}
/*
 * dp[1] = 1
 * dp[2] = 1
 * dp[3] = 1
 * dp[4] = 2
 * dp[5] = 2
 * dp[6] = dp[1] + dp[5]
 * dp[7] = dp[2] + dp[6]
 * dp[8] = dp[3] + dp[7]
*/