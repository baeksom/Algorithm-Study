import java.util.*;
public class p11726_241113 {
	static int n;
	static Integer[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new Integer[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.println(recur(n) % 10007);
	}
	
	static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = recur(n-1) + recur(n-2);
		}
		return dp[n];
	}
}