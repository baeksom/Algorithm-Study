import java.util.*;
import java.io.*;
public class p9095_241112 {
	static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		for(int i=0; i<test_case; i++) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[n+1];
			sb.append(recur(n)).append('\n');
		}
		System.out.println(sb.toString());
	}
	static int recur(int n) {
		if(n == 1) return dp[n] = 1; // 1을 나타내는 방법 - 1
		else if(n == 2) return dp[n] = 2; // 2를 나타내는 방법 - 1+1, 2
		else if(n == 3) return dp[n] = 4; // 3을 나타내는 방법 - 1+1+1, 1+2, 2+1, 3
		else return dp[n] = recur(n-3) + recur(n-2) + recur(n-1);
	}
}