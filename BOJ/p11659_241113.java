import java.util.*;
public class p11659_241113 {
	static int n, m;
	static int[] arr;
	static Integer[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = arr[i-1] + sc.nextInt();		
		}
		
		for(int t=0; t<m; t++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(arr[end] - arr[start-1]);
		}
		
	}
}