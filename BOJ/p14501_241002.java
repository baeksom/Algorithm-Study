import java.util.Scanner;
public class Solution14501 {
    static int n;
    static int[] t, p, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 기간, 금액
        t = new int[n];
        p = new int[n];
        dp = new int[n+1];
        for(int i=0; i<n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            if(i+t[i] <= n) {
                dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[n-1]);
    }
}