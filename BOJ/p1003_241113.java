import java.util.*;
import java.io.*;
public class p1003_241113 {
	static int[][] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int test_case = sc.nextInt();
		
		cnt = new int[41][2];
		cnt[0][0] = 1;
		cnt[1][1] = 1;
		for(int i=2; i<=40; i++) {
			cnt[i][0] = cnt[i-2][0] + cnt[i-1][0];
			cnt[i][1] = cnt[i-2][1] + cnt[i-1][1];
		}
		
		for(int t=0; t<test_case; t++) {
			int n = sc.nextInt();
			sb.append(cnt[n][0]).append(" ").append(cnt[n][1]).append('\n');
		}
		System.out.println(sb.toString());
	}
}

/*
 * 0 - 1 0
 * 1 - 0 1
 * 2 - 1 1
 * 3 - 1 2
*/ 