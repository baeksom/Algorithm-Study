import java.util.*;
import java.io.*;
public class p2193_241114 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		long[] dp = new long[n+1];
		
		dp[1] = 1; // 1
		if(n>=2) dp[2] = 1; // 10
		
		// dp[n-1]에 0을 붙이는 경우 + dp[n-2]에 01을 붙이는 경우
		if(n>=3) {
			for(int i=3; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		System.out.println(dp[n]);
	}
}